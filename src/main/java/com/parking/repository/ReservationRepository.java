package com.parking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.parking.entity.Reservation;
import com.parking.entity.Slot;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
	
	@Query("SELECT r FROM Reservation r " +
	           "WHERE r.slot.id = :slotId " +
	           "AND r.status = 'BOOKED' " +
	           "AND r.startTime < :endTime " +
	           "AND r.endTime > :startTime")
	    List<Reservation> findOverlaps(Long slotId,
	                                   LocalDateTime startTime,
	                                   LocalDateTime endTime);
	
	List<Reservation> findBySlotAndEndTimeAfterAndStartTimeBefore(
            @Param("slot") Slot slot,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );
}
