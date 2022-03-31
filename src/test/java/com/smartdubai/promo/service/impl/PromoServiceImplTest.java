/**
 * 
 */
package com.smartdubai.promo.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.smartdubai.promo.entity.Promo;
import com.smartdubai.promo.exception.ExpiredPromoCode;
import com.smartdubai.promo.exception.InvalidPromoCode;
import com.smartdubai.promo.repo.PromoRepository;

/**
 * @author abhinav
 *
 */
@ExtendWith(SpringExtension.class)
class PromoServiceImplTest {

	@Mock
	private PromoRepository promoRepository;

	@InjectMocks
	private PromoServiceImpl serviceImpl;

	/**
	 * Test method for
	 * {@link com.smartdubai.promo.service.impl.PromoServiceImpl#fetchPromotionDetailsByCode(java.lang.String)}.
	 */
	@Test
	void testFetchPromotionDetailsByCode() {
		Promo promo = new Promo();
		promo.setPromoCode("TESTPROMO");
		promo.setPromoType("Test_Type");
		promo.setPromoValue(10f);
		promo.setMaxDiscount(10d);
		promo.setExpiry(Date.from(LocalDateTime.now().plusDays(1).atZone(ZoneId.systemDefault()).toInstant()));

		when(promoRepository.findPromoByPromoCode(Mockito.anyString())).thenReturn(promo);

		Promo thePromo = serviceImpl.fetchPromotionDetailsByCode(Mockito.anyString());

		assertNotNull(thePromo);
		assertThat(promo.getPromoCode()).isSameAs(thePromo.getPromoCode());
		verify(promoRepository).findPromoByPromoCode(Mockito.anyString());
	}

	/**
	 * Test method for
	 * {@link com.smartdubai.promo.service.impl.PromoServiceImpl#fetchPromotionDetailsByCode(java.lang.String)}.
	 */
	@Test
	void testFetchPromotionDetailsByCode_WithInvalidPromoCode() {
		when(promoRepository.findPromoByPromoCode(Mockito.anyString())).thenReturn(null);
		assertThrows(InvalidPromoCode.class, () -> {
			serviceImpl.fetchPromotionDetailsByCode(Mockito.anyString());
		});
		verify(promoRepository).findPromoByPromoCode(Mockito.anyString());
	}

	/**
	 * Test method for
	 * {@link com.smartdubai.promo.service.impl.PromoServiceImpl#fetchPromotionDetailsByCode(java.lang.String)}.
	 */
	@Test
	void testFetchPromotionDetailsByCode_WithExpiredPromoCode() {
		Promo promo = new Promo();
		promo.setPromoCode("TESTPROMO");
		promo.setPromoType("Test_Type");
		promo.setPromoValue(10f);
		promo.setMaxDiscount(10d);
		promo.setExpiry(new Date());

		when(promoRepository.findPromoByPromoCode(Mockito.anyString())).thenReturn(promo);
		assertThrows(ExpiredPromoCode.class, () -> {
			serviceImpl.fetchPromotionDetailsByCode(Mockito.anyString());
		});
		verify(promoRepository).findPromoByPromoCode(Mockito.anyString());
	}

}
