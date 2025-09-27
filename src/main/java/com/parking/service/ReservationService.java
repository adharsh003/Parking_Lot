package com.parking.service;

import java.math.BigDecimal;
import java.util.List;

import com.parking.entity.Reservation;

public interface ReservationService  {
	Reservation createReservation(Reservation reservation);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();
    public BigDecimal calculateAmount(Reservation reservation);
    boolean cancelReservation(Long id);
}
