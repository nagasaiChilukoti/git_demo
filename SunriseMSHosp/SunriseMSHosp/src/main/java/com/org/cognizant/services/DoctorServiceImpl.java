package com.org.cognizant.services;

import com.org.cognizant.entities.Doctor;
import com.org.cognizant.repositories.DoctorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepo doctorRepo;

    @Override
    public void create(Doctor doctor) {
        doctorRepo.save(doctor);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepo.findById(id).orElse(null);
    }

    @Override
    public List<Doctor> getBySpecialization(String specialization) {
        return doctorRepo.findBySpecialization(specialization);
    }


}
