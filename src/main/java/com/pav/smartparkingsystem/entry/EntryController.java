package com.pav.smartparkingsystem.entry;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Prajesh V Ananthan
 * Date: 25/11/2025
 */
@RestController
@RequestMapping("/parking")
@AllArgsConstructor
public class EntryController {

    private final EntryService entryService;
    private final ExitService exitService;

    @PostMapping("/entry")
    public ResponseEntity<String> vehicleEntry(@RequestParam String vehicleNumber) {
        entryService.vehicleEntry(vehicleNumber);
        return ResponseEntity.ok("Vehicle entered!" + vehicleNumber);
    }

    @PostMapping("/exit")
    public ResponseEntity<String> vehicleExit(@RequestParam String vehicleNumber) {
        exitService.vehicleExit(vehicleNumber);
        return ResponseEntity.ok("Vehicle exited!" + vehicleNumber);
    }
}
