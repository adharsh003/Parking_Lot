package com.parking.exception;

public class InvalidReservationTimeException extends RuntimeException {
	public InvalidReservationTimeException(String message) {
        super(message);
    }
}
