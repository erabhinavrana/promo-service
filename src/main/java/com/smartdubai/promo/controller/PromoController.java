/**
 * 
 */
package com.smartdubai.promo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartdubai.promo.entity.Promo;
import com.smartdubai.promo.service.PromoService;

/**
 * @author abhinav
 *
 */
@RestController
@RequestMapping("/api/v1")
public class PromoController {

	@Autowired
	private PromoService promoService;

	/**
	 * @param code
	 * @return
	 */
	@GetMapping("/promos/{code}")
	public Promo getPromoDetails(@PathVariable String code) {
		return promoService.fetchPromotionDetailsByCode(code);
	}
}
