package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.models.Doctor;
import com.example.HospitalManagementSystem.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

   @Autowired
    DoctorService doctorService;


    @PostMapping
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.save(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeDoctor(@PathVariable("id") Long doctorId) {
        doctorService.deleteById(doctorId);
        return ResponseEntity.noContent().build();
    }
}