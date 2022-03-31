/**
 * 
 */
package com.smartdubai.promo.exception;

/**
 * @author abhinav
 *
 */
public class ExpiredPromoCode extends RuntimeException {

	private static final long serialVersionUID = 6961199454961689282L;

	/**
	 * @param message
	 * @param cause
	 */
	public ExpiredPromoCode(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public ExpiredPromoCode(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ExpiredPromoCode(Throwable cause) {
		super(cause);
	}

}
