package com.parking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.parking.entity.Reservation;
import com.parking.entity.Slot;
import com.parking.repository.ReservationRepository;
import com.parking.repository.SlotRepository;

@Service
public class SlotServiceImpl implements SlotService {
	
	private final SlotRepository slotRepository;
	private final ReservationRepository reservationRepository;

	    public SlotServiceImpl(SlotRepository slotRepository,
	                           ReservationRepository reservationRepository) {
	        this.slotRepository = slotRepository;
	        this.reservationRepository = reservationRepository;
	    }
	
	@Override
	public Slot addSlot(Slot slot) {
		return slotRepository.save(slot);
	}

	@Override
	public List<Slot> getSlots() {
		return slotRepository.findAll();
	}

	@Override
	public Slot getSlot(Long id) {
		 return slotRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteSlot(Long id) {
		 slotRepository.deleteById(id);
		
	}

	@Override
    public List<Slot> getAvailableSlots(LocalDateTime startTime, LocalDateTime endTime) {
        // Fetch all slots
        List<Slot> allSlots = slotRepository.findAll();

        // Filter slots that are reserved in the given time range
        return allSlots.stream()
                .filter(slot -> {
                    List<Reservation> overlapping = reservationRepository
                            .findBySlotAndEndTimeAfterAndStartTimeBefore(slot, startTime, endTime);
                    return overlapping.isEmpty();
                })
                .toList();
    }

}
