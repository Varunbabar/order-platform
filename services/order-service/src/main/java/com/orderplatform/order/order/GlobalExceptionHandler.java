package com.orderplatform.order.order;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(OrderNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ApiErrorResponse handleOrderNotFound(
	        OrderNotFoundException ex,
	        HttpServletRequest request) {

	    return new ApiErrorResponse(
	        LocalDateTime.now(),
	        HttpStatus.NOT_FOUND.value(),
	        ex.getMessage(),
	        request.getRequestURI()
	    );
	}
}