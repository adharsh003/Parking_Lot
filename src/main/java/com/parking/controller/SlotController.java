package com.parking.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parking.entity.Slot;
import com.parking.service.SlotService;

@RestController
@RequestMapping("/slot")
public class SlotController {
	
	@Autowired
	private SlotService slotService;

	    // Add a slot
	    @PostMapping
	    public Slot addSlot(@RequestBody Slot slot){
	        return slotService.addSlot(slot);
	    }

	    // Get all slots
	    @GetMapping
	    public List<Slot> getSlots(){
	        return slotService.getSlots();
	    }

	    // Get a slot by ID
	    @GetMapping("/{id}")
	    public Slot getSlot(@PathVariable Long id) {
	        return slotService.getSlot(id);
	    }

	    // Delete a slot by ID
	    @DeleteMapping("/{id}")
	    public String deleteSlot(@PathVariable Long id) {
	        slotService.deleteSlot(id);
	        return "Slot deleted successfully!";
	    }

	    @GetMapping("/availability")
	    public List<Slot> getAvailableSlots(
	            @RequestParam("startTime") String start,
	            @RequestParam("endTime") String end) {

	        LocalDateTime startTime = LocalDateTime.parse(start.trim());
	        LocalDateTime endTime = LocalDateTime.parse(end.trim());
	        return slotService.getAvailableSlots(startTime, endTime);
	    }

	

}
