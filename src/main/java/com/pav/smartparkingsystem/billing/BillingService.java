package com.pav.smartparkingsystem.billing;

import com.pav.smartparkingsystem.event.VehicleExitEvent;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author Prajesh V Ananthan
 * Date: 25/11/2025
 */

@Service
@AllArgsConstructor
@Slf4j
public class BillingService {

    private final BillingRecordRepository billingRecordRepository;

    @EventListener
    public void handleVehicleExit(VehicleExitEvent event) {
        Duration duration = Duration.between(event.entryTime(), event.exitTime());
        // Calculate parking fee
        double amount = Math.max(20, (duration.toMinutes() / 60) * 50);
        BillingRecord record = new BillingRecord(null, event.vehicleNumber(), amount, event.exitTime());
        billingRecordRepository.save(record);

        log.info("Billing record saved for vehicle {} from {} to {}",
                event.vehicleNumber(), event.entryTime(), event.exitTime());
    }
}