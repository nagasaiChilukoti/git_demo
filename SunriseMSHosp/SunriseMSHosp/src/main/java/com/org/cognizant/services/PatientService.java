package com.org.cognizant.services;

import com.org.cognizant.entities.Patient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PatientService {
    public void create(Patient patient);

    public List<Patient> getAllPatients();

    public Patient getById(Long id);
}
