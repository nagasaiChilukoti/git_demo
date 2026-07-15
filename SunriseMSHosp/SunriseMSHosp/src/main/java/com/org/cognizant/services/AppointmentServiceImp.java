package com.org.cognizant.services;

import com.org.cognizant.Enum.StatusEnum;
import com.org.cognizant.entities.Appointment;
import com.org.cognizant.entities.Doctor;
import com.org.cognizant.repositories.AppointmentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class AppointmentServiceImp implements AppointmentService{

    private final AppointmentRepo appointmentRepo;
    @Override
    public String create(Appointment appointment) {
        Doctor doc=appointment.getDoctor();
        Long id=doc.getDoctorId();
        Appointment app= appointmentRepo.findByDoctor_DoctorIdAndAppointmentDate(id,appointment.getAppointmentDate());
        if(app==null){
            appointmentRepo.save(appointment);
            return "Appointment Created";
        }
        else if(app.getStatus()== StatusEnum.COMPLETED){
            appointmentRepo.save(appointment);
            return "Appointment Created";
        }
        else{
            return "Doctor is busy";
        }
    }

    @Override
    public Appointment updateStatus(Long id,StatusEnum status) {
        Appointment app=appointmentRepo.findById(id).orElse(null);
        if(app!=null){
            app.setStatus(status);
        }
        return app;
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentRepo.findAll();
    }

    @Override
    public List<Appointment> getByDoctorId(Long id) {
        return appointmentRepo.findByDoctor_DoctorId(id);
    }

    @Override
    public List<Appointment> getByPatientId(Long id) {
        return appointmentRepo.findByPatient_PatientId(id);
    }

    @Override
    public List<Appointment> getByDate(Date startDate, Date endDate) {
        return appointmentRepo.findByAppointmentDateBetween(startDate,endDate);
    }
}
