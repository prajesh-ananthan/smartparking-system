package com.pav.smartparkingsystem.allocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Prajesh V Ananthan
 * Date: 24/11/2025
 */

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

    // Find available slot and assign vehicle number to slot
    Optional<Slot> findFirstByAvailableTrue();

    Optional<Slot> findByVehicleNumber(String vehicleNumber);
}
