package com.pav.smartparkingsystem.allocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Prajesh V Ananthan
 * Date: 24/11/2025
 */

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

}
