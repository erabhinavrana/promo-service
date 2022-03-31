/**
 * 
 */
package com.smartdubai.promo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author abhinav
 *
 */
@Data
@AllArgsConstructor
public class PromoErrorResponse {
	private int status;
	private String message;
	private long timestamp;
}
