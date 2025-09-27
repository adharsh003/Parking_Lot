package com.parking.service;

import java.time.LocalDateTime;
import java.util.List;

import com.parking.entity.Slot;

public interface SlotService {
	
	 Slot addSlot(Slot slot);
	 List<Slot> getSlots();
	 Slot getSlot(Long id);
	 void deleteSlot(Long id);
	 List<Slot> getAvailableSlots(LocalDateTime startTime, LocalDateTime endTime);
	 

}
