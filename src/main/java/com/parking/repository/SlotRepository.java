package com.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.entity.Slot;

public interface SlotRepository extends JpaRepository<Slot, Long>{
	List<Slot> findByStatus(String status);
}
