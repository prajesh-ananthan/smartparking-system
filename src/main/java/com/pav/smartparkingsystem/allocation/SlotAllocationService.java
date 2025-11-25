package com.pav.smartparkingsystem.allocation;

import com.pav.smartparkingsystem.event.VehicleEnteredEvent;
import com.pav.smartparkingsystem.event.VehicleExitEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by Prajesh V Ananthan
 * Date: 25/11/2025
 */

@Service
@Slf4j
@AllArgsConstructor
public class SlotAllocationService {

    private final SlotRepository slotRepository;

    @EventListener
    public void handleVehicleEntry(VehicleEnteredEvent vehicleEnteredEvent) {

        Slot slot = slotRepository.findFirstByAvailableTrue().orElseThrow(() -> new RuntimeException("No available slot!"));
        slot.setVehicleNumber(vehicleEnteredEvent.vehicleNumber());
        slot.setAvailable(false);

        log.info("Vehicle {} allocated slot {}", vehicleEnteredEvent.vehicleNumber(), slot.getSlotCode());

        slotRepository.save(slot);
    }

    @EventListener
    public void handleVehicleExit(VehicleExitEvent vehicleExitEvent) {
        slotRepository.findByVehicleNumber(vehicleExitEvent.vehicleNumber()).ifPresentOrElse(slot -> {
            slot.setAvailable(true);
            slot.setVehicleNumber(null);
            slotRepository.save(slot);
            log.info("Slot {} released for vehicle {}", slot.getSlotCode(), vehicleExitEvent.vehicleNumber());
        }, () -> {
            throw new RuntimeException("No slot found for vehicle " + vehicleExitEvent.vehicleNumber());
        });
    }
}