package com.healthcare.api.service;

import com.healthcare.api.entity.Doctor;
import com.healthcare.api.entity.Patient;
import com.healthcare.api.repository.AppointmentRepository;
import com.healthcare.api.repository.DoctorRepository;
import com.healthcare.api.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class AppointmentServiceTest {

    @Autowired
    public AppointmentService appointmentService;

    @Autowired
    public AppointmentRepository appointmentRepository;

    @Autowired
    public PatientRepository patientRepository;

    @Autowired
    public DoctorRepository doctorRepository;

    private Patient patientTest;
    private Doctor doctorTest;

    @Test
    void createAppointment() {

    }

    @Test
    void getAllAppointments() {
    }

    @Test
    void getAppointmentByPatient() {
    }

    @Test
    void updateAppointment() {
    }

    @Test
    void cancelAppointment() {
    }
}