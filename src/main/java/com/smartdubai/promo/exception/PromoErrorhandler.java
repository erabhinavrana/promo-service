/**
 * 
 */
package com.smartdubai.promo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author abhinav
 *
 */
@ControllerAdvice
public class PromoErrorhandler {

	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<?> handleException(InvalidPromoCode ex) {
		PromoErrorResponse errorResponse = new PromoErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public ResponseEntity<?> handleException(Exception ex) {
		PromoErrorResponse errorResponse = new PromoErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
