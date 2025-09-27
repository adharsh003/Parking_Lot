package com.parking.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.parking.enums.ReservationStatus;
import com.parking.enums.VehicleType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class Reservation {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JsonBackReference
	    private Slot slot;

	    private String vehicleNumber;

	    @Enumerated(EnumType.STRING)
	    private VehicleType vehicleType;

	    private LocalDateTime startTime;
	    private LocalDateTime endTime;

	    private BigDecimal amount;

	    @Enumerated(EnumType.STRING)
	    private ReservationStatus status = ReservationStatus.BOOKED;

	    public Reservation() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Slot getSlot() {
			return slot;
		}

		public void setSlot(Slot slot) {
			this.slot = slot;
		}

		public String getVehicleNumber() {
			return vehicleNumber;
		}

		public void setVehicleNumber(String vehicleNumber) {
			this.vehicleNumber = vehicleNumber;
		}

		public VehicleType getVehicleType() {
			return vehicleType;
		}

		public void setVehicleType(VehicleType vehicleType) {
			this.vehicleType = vehicleType;
		}

		public LocalDateTime getStartTime() {
			return startTime;
		}

		public void setStartTime(LocalDateTime startTime) {
			this.startTime = startTime;
		}

		public LocalDateTime getEndTime() {
			return endTime;
		}

		public void setEndTime(LocalDateTime endTime) {
			this.endTime = endTime;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public ReservationStatus getStatus() {
			return status;
		}

		public void setStatus(ReservationStatus status) {
			this.status = status;
		}
	
}
