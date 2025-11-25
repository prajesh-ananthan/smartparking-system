package com.pav.smartparkingsystem.event;

import java.time.LocalDateTime;

/**
 * @author Prajesh V Ananthan
 * Date: 25/11/2025
 */
public record VehicleExitEvent(String vehicleNumber, LocalDateTime entryTime, LocalDateTime exitTime) {
}
