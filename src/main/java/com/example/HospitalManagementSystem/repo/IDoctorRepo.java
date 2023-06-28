package com.example.HospitalManagementSystem.repo;

import com.example.HospitalManagementSystem.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor,Long> {

    List<Doctor> findBySpecialityAndCity(String speciality, String city);
}
