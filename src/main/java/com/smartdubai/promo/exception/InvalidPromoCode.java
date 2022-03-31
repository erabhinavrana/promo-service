/**
 * 
 */
package com.smartdubai.promo.exception;

/**
 * @author abhinav
 *
 */
public class InvalidPromoCode extends RuntimeException {

	private static final long serialVersionUID = 6961199454961689282L;

	/**
	 * @param message
	 * @param cause
	 */
	public InvalidPromoCode(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public InvalidPromoCode(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InvalidPromoCode(Throwable cause) {
		super(cause);
	}

}
