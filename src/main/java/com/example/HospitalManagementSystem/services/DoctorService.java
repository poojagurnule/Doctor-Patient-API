package com.example.HospitalManagementSystem.services;

import com.example.HospitalManagementSystem.models.Doctor;
import com.example.HospitalManagementSystem.repo.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepo doctorRepo ;
    public void deleteById(Long doctorId) {
        doctorRepo.deleteById(doctorId);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepo.save(doctor);
    }
}
