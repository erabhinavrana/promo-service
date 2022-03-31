/**
 * 
 */
package com.smartdubai.promo.service;

import com.smartdubai.promo.entity.Promo;

/**
 * @author abhinav
 *
 */
public interface PromoService {

	/**
	 * @param code
	 * @return
	 */
	Promo fetchPromotionDetailsByCode(String code);
}
