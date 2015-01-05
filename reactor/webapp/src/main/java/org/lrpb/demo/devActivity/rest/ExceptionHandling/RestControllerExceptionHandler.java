/**
 * 
 */
package org.lrpb.demo.devActivity.rest.ExceptionHandling;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Louis-Rene
 *
 * This is a controller advice class to handle 
 * exceptions occurring in rest services and return a standardized json error of type
 * application/vnd.error
 *
 */
@ControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler {

	
	@ExceptionHandler(IllegalStateException.class)
	ResponseEntity<VndErrors> badRequestFormat(IllegalStateException e) {
		return errorResponseEntity(e, HttpStatus.PRECONDITION_REQUIRED,
				"InvalidState");

	}
	 
	@ExceptionHandler(HttpMessageNotReadableException.class)
	ResponseEntity<VndErrors> badRequestFormat(HttpMessageNotReadableException e) {
		return errorResponseEntity(e, HttpStatus.BAD_REQUEST,
				"Invalid_JSON_request");
	}

	// Invalid request goes to converters
	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<VndErrors> badRequestFormat(MethodArgumentNotValidException e) {
		return errorResponseEntity(e, HttpStatus.BAD_REQUEST,
				"Invalid_Argument");
	}
	
	@ExceptionHandler(Exception.class)
	ResponseEntity<VndErrors> genericException(Exception e) {
		// Unknown Error
		return errorResponseEntity(e, HttpStatus.INTERNAL_SERVER_ERROR, e
				.getClass().toString());

	}

	protected <E extends Exception> ResponseEntity<VndErrors> errorResponseEntity(E e
			,HttpStatus httpStatus
			,String logRef)
	{
		MediaType mediaType = MediaType.parseMediaType("application/vnd.error");
		String msg = StringUtils.hasText(
				e.getMessage() )? e.getMessage() : e.getClass().getSimpleName();
				
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		return new ResponseEntity<VndErrors>(new VndErrors(logRef, msg ), headers,httpStatus);
	}
	
}
