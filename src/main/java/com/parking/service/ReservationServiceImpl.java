package com.parking.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.parking.entity.Reservation;
import com.parking.enums.VehicleType;
import com.parking.exception.InvalidReservationTimeException;
import com.parking.exception.SlotAlreadyBookedException;
import com.parking.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }
	
	@Override
	public Reservation createReservation(Reservation reservation) {
		
		List<Reservation> overlaps = reservationRepository.findOverlaps(
		        reservation.getSlot().getId(),
		        reservation.getStartTime(),
		        reservation.getEndTime()
		);

		if (!overlaps.isEmpty()) {
			 throw new SlotAlreadyBookedException("Slot already booked in this time range");
		}
		
		if (reservation.getEndTime().isBefore(reservation.getStartTime())) {
		    throw new InvalidReservationTimeException("End time cannot be before start time");
		}
		
		
		 long minutes = java.time.Duration.between(reservation.getStartTime(), reservation.getEndTime()).toMinutes();
		 long hours = (minutes + 59) / 60;
		 
		 BigDecimal rate;
		 if (reservation.getVehicleType() == VehicleType.FOUR_WHEELER) {
		     rate = BigDecimal.valueOf(50);
		 } else {
		     rate = BigDecimal.valueOf(20);
		 }
		 
		 reservation.setAmount(rate.multiply(BigDecimal.valueOf(hours)));

		   
		 return reservationRepository.save(reservation);
	}

	@Override
	public Reservation getReservationById(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}

	@Override
	public List<Reservation> getAllReservations() {
		return reservationRepository.findAll();
	}
	
	@Override
	public BigDecimal calculateAmount(Reservation reservation) {
	    long hours = Duration.between(reservation.getStartTime(), reservation.getEndTime()).toHours();
	    BigDecimal rate;

	    switch (reservation.getVehicleType()) {
	        case FOUR_WHEELER:
	            rate = BigDecimal.valueOf(50); // 50 per hour
	            break;
	        case TWO_WHEELER:
	            rate = BigDecimal.valueOf(20); // 20 per hour
	            break;
	        default:
	            rate = BigDecimal.ZERO;
	    }

	    return rate.multiply(BigDecimal.valueOf(hours));
	}

	@Override
	public boolean cancelReservation(Long id) {
		Optional<Reservation> reservationOpt = reservationRepository.findById(id);
        if (reservationOpt.isPresent()) {
            reservationRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
