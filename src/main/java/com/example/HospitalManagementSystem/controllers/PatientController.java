package com.example.HospitalManagementSystem.controllers;

import com.example.HospitalManagementSystem.models.Doctor;
import com.example.HospitalManagementSystem.models.Patient;
import com.example.HospitalManagementSystem.services.DoctorService;
import com.example.HospitalManagementSystem.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    DoctorService doctorService;

    @Autowired
    PatientService patientService;


    @PostMapping("add/patient")
    ResponseEntity<String> addPatient(@RequestBody @Valid Patient patient){
        patientService.addPatient(patient);
        return new ResponseEntity<>("Patient added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("remove/patient/{patientId}")
    ResponseEntity<String> deletePatient(@PathVariable Integer patientId){
        patientService.removePatient(patientId);
        return new ResponseEntity<>("Patient removed successfully",HttpStatus.OK);
    }
    @GetMapping("/{id}/suggest-doctors")
    public ResponseEntity<List<Doctor>> suggestDoctors(@PathVariable("id") Integer patientId) {
        List<Doctor> optionalPatient = patientService.suggestDoctors(patientId);
        if (optionalPatient.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(optionalPatient);
    }


}