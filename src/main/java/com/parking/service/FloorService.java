package com.parking.service;

import java.util.List;

import com.parking.entity.Floor;

public interface FloorService {
	
	Floor createFloor(Floor floor);
    List<Floor> getAllFloors();
    Floor getFloorById(Long id);
    
}
