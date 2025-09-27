package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.entity.Floor;

public interface FloorRepository extends JpaRepository<Floor,Long> {

}
