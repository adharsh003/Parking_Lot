package com.parking.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Slot {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Slot number is required")
	    @Column(nullable = false)
	    private String slotNumber;

	    @NotBlank(message = "Vehicle type is required")
	    @Column(nullable = false)
	    private String vehicleType; 

	    @NotBlank(message = "Status is required")
	    @Column(nullable = false)
	    private String status; 

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "floor_id", nullable = false)
	    @NotNull(message = "Floor must be specified")
	    @JsonBackReference
	    private Floor floor;
	    
	    
	    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Reservation> reservations = new ArrayList<>();

	    
	    public Slot() {}

	    public Slot(String slotNumber, String vehicleType, String status, Floor floor) {
	        this.slotNumber = slotNumber;
	        this.vehicleType = vehicleType;
	        this.status = status;
	        this.floor = floor;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getSlotNumber() {
			return slotNumber;
		}

		public void setSlotNumber(String slotNumber) {
			this.slotNumber = slotNumber;
		}

		public String getVehicleType() {
			return vehicleType;
		}

		public void setVehicleType(String vehicleType) {
			this.vehicleType = vehicleType;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Floor getFloor() {
			return floor;
		}

		public void setFloor(Floor floor) {
			this.floor = floor;
		}

		public List<Reservation> getReservations() {
			return reservations;
		}

		public void setReservations(List<Reservation> reservations) {
			this.reservations = reservations;
		}

}
