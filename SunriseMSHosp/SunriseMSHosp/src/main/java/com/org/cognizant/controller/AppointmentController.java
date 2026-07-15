package com.org.cognizant.controller;

import com.org.cognizant.Enum.StatusEnum;
import com.org.cognizant.entities.Appointment;
import com.org.cognizant.services.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@AllArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public String create(@RequestBody Appointment appointment){
        return appointmentService.create(appointment);
    }

    @PatchMapping("/{id}/status/{status}")
    public Appointment updateStatus(@PathVariable Long id, @PathVariable StatusEnum status){
        return appointmentService.updateStatus(id,status);
    }

    @GetMapping
    public List<Appointment> getAll(){
        return appointmentService.getAll();
    }

    @GetMapping("/doctorId/{id}")
    public List<Appointment> getByDoctorId(@PathVariable Long id){
        return appointmentService.getByDoctorId(id);
    }

    @GetMapping("/patientId/{id}")
    public List<Appointment> getByPatientId(@PathVariable Long id){
        return appointmentService.getByPatientId(id);
    }

    @GetMapping("/date/{start}/{end}")
    public List<Appointment> getByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")  Date start,@PathVariable  @DateTimeFormat(pattern = "yyyy-MM-dd") Date end){
        return appointmentService.getByDate(start,end);
    }
}
