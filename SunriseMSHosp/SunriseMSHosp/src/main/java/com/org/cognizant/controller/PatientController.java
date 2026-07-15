package com.org.cognizant.controller;

import com.org.cognizant.entities.Patient;
import com.org.cognizant.services.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public String create(@RequestBody Patient patient){
        patientService.create(patient);
        return "Patient record created successfully!";
    }

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Long id){
        return patientService.getById(id);
    }
}
