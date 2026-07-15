package com.org.cognizant.services;

import com.org.cognizant.entities.Doctor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DoctorService {
    public void create(Doctor doctor);
    public List<Doctor> getAllDoctors();
    public Doctor getById(Long id);
    public List<Doctor> getBySpecialization(String specialization);
}
