/**
 * 
 */
package com.smartdubai.promo.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartdubai.promo.entity.Promo;
import com.smartdubai.promo.exception.ExpiredPromoCode;
import com.smartdubai.promo.exception.InvalidPromoCode;
import com.smartdubai.promo.repo.PromoRepository;
import com.smartdubai.promo.service.PromoService;

/**
 * @author abhinav
 *
 */
@Service
public class PromoServiceImpl implements PromoService {

	@Autowired
	private PromoRepository promoRepository;

	/**
	 * @param code
	 * @return
	 */
	@Override
	public Promo fetchPromotionDetailsByCode(String code) {

		Promo thePromo = Optional.ofNullable(promoRepository.findPromoByPromoCode(code))
				.orElseThrow((() -> new InvalidPromoCode("Invalid Promo Code!")));

		if (thePromo.getExpiry().before(new Date())) {
			throw new ExpiredPromoCode("Promo Code Expired!");
		}

		return thePromo;
	}

}
