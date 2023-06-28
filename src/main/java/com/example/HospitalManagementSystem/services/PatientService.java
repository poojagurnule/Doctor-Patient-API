package com.example.HospitalManagementSystem.services;

import com.example.HospitalManagementSystem.models.Doctor;
import com.example.HospitalManagementSystem.models.Patient;
import com.example.HospitalManagementSystem.repo.IDoctorRepo;
import com.example.HospitalManagementSystem.repo.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    IPatientRepo patientRepo ;
    @Autowired
    IDoctorRepo doctorRepo;

    public Patient addPatient(Patient patient) {
        return patientRepo.save(patient);
    }

    public void removePatient(Integer patientId) {
        patientRepo.deleteById(patientId);
    }

    public List<Doctor> suggestDoctors(Integer patientId) {
        Optional<Patient> optionalPatient = patientRepo.findById(patientId);
        if (optionalPatient.isEmpty()) {
            throw new IllegalArgumentException("Patient not found");
        }

        Patient patient = optionalPatient.get();

        // Check if patient's city is one of the allowed cities
        if (!isValidCity(patient.getCity())) {
            throw new RuntimeException("Sorry!! We are still waiting to expand to your location");
        }

        // Find doctors with the same speciality as patient's symptom in the patient's city


    List<Doctor> doctors = doctorRepo.findBySpecialityAndCity(String.valueOf(patient.getSymptom()), patient.getCity());
        if (doctors.isEmpty()) {
        throw new IllegalStateException("There isn't any doctor present at your location for your symptom");
    }

        return doctors;
}

    private boolean isValidCity(String city) {
        return city.equals("Delhi") || city.equals("Noida") || city.equals("Faridabad");
    }
}

