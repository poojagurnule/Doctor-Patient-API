package com.example.HospitalManagementSystem.repo;

import com.example.HospitalManagementSystem.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepo extends JpaRepository<Patient,Integer> {
}
