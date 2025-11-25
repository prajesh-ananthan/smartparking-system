package com.pav.smartparkingsystem.billing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Prajesh V Ananthan
 * Date: 25/11/2025
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BillingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vehicleNumber;
    private double amount;
    private LocalDateTime billingTime;
}