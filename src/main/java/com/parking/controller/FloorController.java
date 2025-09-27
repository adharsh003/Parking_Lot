package com.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.entity.Floor;
import com.parking.service.FloorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/floors")
public class FloorController {
	
	@Autowired
	private final FloorService floorService;

    public FloorController(FloorService floorService) {
        this.floorService = floorService;
    }

    @PostMapping
    public Floor createFloor(@Valid @RequestBody Floor floor) {
        return floorService.createFloor(floor);
    }

    @GetMapping
    public List<Floor> getAllFloors() {
        return floorService.getAllFloors();
    }

    @GetMapping("/{id}")
    public Floor getFloorById(@PathVariable Long id) {
        return floorService.getFloorById(id);
    }
}

