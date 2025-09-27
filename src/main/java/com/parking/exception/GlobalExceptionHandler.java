package com.parking.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(SlotAlreadyBookedException.class)
	    public String handleSlotAlreadyBooked(SlotAlreadyBookedException ex) {
	        return ex.getMessage(); 
	    }
	 
	 @ExceptionHandler(InvalidReservationTimeException.class)
	    public String handleInvalidTime(InvalidReservationTimeException ex) {
	        return ex.getMessage();
	    }
}
