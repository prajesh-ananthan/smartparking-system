package com.pav.smartparkingsystem.entry;

import com.pav.smartparkingsystem.entry.domain.ParkingEntry;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by Prajesh V Ananthan
 * Date: 25/11/2025
 */

@Service
@AllArgsConstructor
public class ExitService {

    private final ParkingEntryRepository parkingEntryRepository;
    private final ApplicationEventPublisher publisher;

    public void vehicleExit(String vehicleNumber) {

        ParkingEntry parkingEntry = parkingEntryRepository.findByVehicleNumberAndActiveTrue(vehicleNumber)
                .orElseThrow(() -> new RuntimeException("No vehicle entry " + vehicleNumber + " found!"));

        parkingEntry.setExitTime(LocalDateTime.now());
        parkingEntry.setActive(false);
        parkingEntryRepository.save(parkingEntry);
        publisher.publishEvent(new VehicleExitEvent(vehicleNumber, parkingEntry.getEntryTime()));

    }


    // allocate a parking slot

    // send notification to user
}
