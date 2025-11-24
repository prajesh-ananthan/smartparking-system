package com.pav.spring_modulith.allocation;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Prajesh V Ananthan
 * Date: 24/11/2025
 */

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slotCode;
    private boolean available;
    private String vehicleNumber;


}
