package com.org.cognizant.services;

import com.org.cognizant.Enum.StatusEnum;
import com.org.cognizant.entities.Appointment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

public interface AppointmentService {
    public String create(Appointment appointment);
    public Appointment updateStatus(Long id,StatusEnum status);
    public List<Appointment> getAll();
    public List<Appointment> getByDoctorId(Long id);
    public List<Appointment> getByPatientId(Long id);
    public List<Appointment> getByDate(Date startDate, Date endDate);
}
