package com.example.HospitalManagementSystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "patient_tbl")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @Length(min = 3,message = "Please enter at least 3 Character")
    private String patientName;
    @Length(max = 20,message = "Please enter maximum 20 Character")
    private String city;
    @Email(message = "Please enter valid email address")
    private String email;
    @Length(min = 10,message = "Please enter minimum 10 numbers")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "symptom", nullable = false)
    private Symptom symptom;


}
