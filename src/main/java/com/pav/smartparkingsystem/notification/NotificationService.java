package com.pav.smartparkingsystem.notification;

import com.pav.smartparkingsystem.event.VehicleEnteredEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by Prajesh V Ananthan
 * Date: 25/11/2025
 */

@Service
@Slf4j
public class NotificationService {

    @EventListener
    public void notifyVehicleEntry(VehicleEnteredEvent vehicleEnteredEvent) {
        log.info("Vehicle {} entered parking lot", vehicleEnteredEvent.vehicleNumber());
    }
}
