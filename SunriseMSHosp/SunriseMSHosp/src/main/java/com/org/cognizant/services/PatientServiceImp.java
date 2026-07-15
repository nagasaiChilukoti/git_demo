package com.org.cognizant.services;

import com.org.cognizant.entities.Patient;
import com.org.cognizant.repositories.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PatientServiceImp implements PatientService{

    private final PatientRepo patientRepo;

    @Override
    public void create(Patient patient) {
        patientRepo.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient getById(Long id) {
        return patientRepo.findById(id).orElse(null);
    }
}
