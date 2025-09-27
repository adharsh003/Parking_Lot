package com.parking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parking.entity.Floor;
import com.parking.repository.FloorRepository;

@Service
public class FloorServiceImpl implements FloorService {
	
	  private final FloorRepository floorRepository;

	    public FloorServiceImpl(FloorRepository floorRepository) {
	        this.floorRepository = floorRepository;
	    }

	@Override
	public Floor createFloor(Floor floor) {
		
		return floorRepository.save(floor);
	}

	@Override
	public List<Floor> getAllFloors() {
		return floorRepository.findAll();
	}

	@Override
	public Floor getFloorById(Long id) {
		return floorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Floor not found with id: " + id));
	}
	
}
