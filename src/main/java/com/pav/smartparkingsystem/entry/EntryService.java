package com.pav.smartparkingsystem.entry;

import com.pav.smartparkingsystem.entry.domain.ParkingEntry;
import com.pav.smartparkingsystem.event.VehicleEnteredEvent;
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
public class EntryService {

    private final ParkingEntryRepository parkingEntryRepository;
    private final ApplicationEventPublisher publisher;

    public void vehicleEntry(String vehicleNumber) {
        ParkingEntry parkingEntry = ParkingEntry.builder()
                .id(null)
                .vehicleNumber(vehicleNumber)
                .entryTime(LocalDateTime.now())
                .exitTime(null)
                .active(true)
                .build();
        parkingEntryRepository.save(parkingEntry);
        publisher.publishEvent(new VehicleEnteredEvent(vehicleNumber, parkingEntry.getEntryTime()));
    }


    // allocate a parking slot

    // send notification to user
}
