package com.pav.smartparkingsystem.entry;

import java.time.LocalDateTime;

/**
 * @author Prajesh V Ananthan
 * Date: 25/11/2025
 */
public record VehicleExitEvent(String vehicleNumber, LocalDateTime entryTime) {
}
