package com.org.cognizant.controller;

import com.org.cognizant.entities.Doctor;
import com.org.cognizant.services.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public String create(@RequestBody Doctor doctor){
        doctorService.create(doctor);
        return "Added Doctor Successfully!";
    }

    @GetMapping
    public List<Doctor> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getBYId(@PathVariable Long id){
        return doctorService.getById(id);
    }

    @GetMapping("/specialization/{specialization}")
    public List<Doctor> getBySpecialization(@PathVariable String specialization){
        return doctorService.getBySpecialization(specialization);
    }
}
