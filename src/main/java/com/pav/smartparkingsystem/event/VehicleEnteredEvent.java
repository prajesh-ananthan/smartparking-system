package com.pav.smartparkingsystem.event;

import java.time.LocalDateTime;

/**
 * Created by Prajesh V Ananthan
 * Date: 25/11/2025
 */
public record VehicleEnteredEvent(String vehicleNumber, LocalDateTime entryTime) {


}
