/**
 * 
 */
package com.smartdubai.promo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.smartdubai.promo.entity.Promo;
import com.smartdubai.promo.exception.InvalidPromoCode;
import com.smartdubai.promo.service.PromoService;

/**
 * @author abhinav
 *
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest(PromoController.class)
class PromoControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PromoService promoService;

	/**
	 * Test method for
	 * {@link com.smartdubai.promo.controller.PromoController#getPromoDetails(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetPromoDetails() throws Exception {
		Promo thePromo = new Promo();
		thePromo.setPromoCode("TESTPROMO");
		thePromo.setPromoType("Test_Type");
		thePromo.setPromoValue(10f);
		thePromo.setMaxDiscount(10d);

		when(promoService.fetchPromotionDetailsByCode(Mockito.anyString())).thenReturn(thePromo);

		mvc.perform(get("/api/v1/promos/" + thePromo.getPromoCode()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$.promoCode", is(thePromo.getPromoCode())));

	}

	/**
	 * Test method for
	 * {@link com.smartdubai.promo.controller.PromoController#getPromoDetails(java.lang.String)}.
	 * 
	 * @throws Exception
	 */
	@Test
	void testGetPromoDetails_WithInvalidPromoCode() throws Exception {
		when(promoService.fetchPromotionDetailsByCode(Mockito.anyString()))
				.thenThrow(new InvalidPromoCode("Invalid Promo Code!"));

		mvc.perform(get("/api/v1/promos/" + "TESTPROMO").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

	}

}
