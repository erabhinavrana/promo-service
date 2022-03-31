/**
 * 
 */
package com.smartdubai.promo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author abhinav
 *
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "bookstore_promo")
public class Promo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "code")
	private String promoCode;
	@Column(name = "type")
	private String promoType;
	@Column(name = "value")
	private Float promoValue;
	@Column(name = "max_discount")
	private Double maxDiscount;
	@Column(name = "expiry_date")
	private Date expiry;
}
