package com.pav.smartparkingsystem.entry;

import com.pav.smartparkingsystem.entry.domain.ParkingEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Prajesh V Ananthan
 * Date: 24/11/2025
 */

@Repository
public interface ParkingEntryRepository extends JpaRepository<ParkingEntry, Long> {

    Optional<ParkingEntry> findByVehicleNumberAndActiveTrue(String vehicleNumber);
}
