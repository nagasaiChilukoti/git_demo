package com.org.cognizant.repositories;

import com.org.cognizant.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    Appointment findByDoctor_DoctorIdAndAppointmentDate(Long id, Date appointmentDate);

    List<Appointment> findByDoctor_DoctorId(Long id);

    List<Appointment> findByPatient_PatientId(Long id);
    List<Appointment> findByAppointmentDateBetween(Date start,Date end);
}
