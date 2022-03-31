/**
 * 
 */
package com.smartdubai.promo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartdubai.promo.entity.Promo;

/**
 * @author abhinav
 *
 */
public interface PromoRepository extends JpaRepository<Promo, Long> {

	/**
	 * @param code
	 * @return
	 */
	Promo findPromoByPromoCode(String code);
}
