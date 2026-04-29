package com.healthcare.api.service;

import com.healthcare.api.dto.AppointmentRequestDTO;
import com.healthcare.api.dto.AppointmentResponseDTO;
import com.healthcare.api.entity.Appointment;
import com.healthcare.api.entity.AppointmentStatus;
import com.healthcare.api.entity.Doctor;
import com.healthcare.api.entity.Patient;
import com.healthcare.api.repository.AppointmentRepository;
import com.healthcare.api.repository.DoctorRepository;
import com.healthcare.api.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

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

    @BeforeEach
    void setUp() {
        Patient patient = new Patient();
        patient.setLastName("Charkaoui");
        patient.setFirstName("Mbarek");
        patient.setEmail("mbarek@gmail.com");
        patient.setPhone("0734124660");
        patientTest = patientRepository.save(patient);

        Doctor doctor = new Doctor();
        doctor.setName("Benjelloun");
        doctor.setSpecialty("Dentist");
        doctor.setPhone("0573676532");
        doctorTest = doctorRepository.save(doctor);
    }

    @Test
    void createAppointment() {
        AppointmentRequestDTO dto = new AppointmentRequestDTO();
        dto.setPatientId(patientTest.getId());
        dto.setDoctorId(doctorTest.getId());
        dto.setAppointmentDate(LocalDateTime.now().plusDays(2));

        AppointmentResponseDTO responseDTO = appointmentService.createAppointment(dto);

        assertNotNull(responseDTO.getId());
        assertEquals(AppointmentStatus.PLANNED, responseDTO.getStatus());
        assertEquals("Mbarek Charkaoui", responseDTO.getPatientCompleteName());

        List<Appointment> allAppointments = appointmentRepository.findAll();
        assertEquals(2, allAppointments.size());
    }

    @Test
    void getAllAppointments() {

    }

    @Test
    void getAppointmentByPatient() {
    }

    @Test
    void updateAppointment() {
        Appointment appointment = new Appointment();
        appointment.setPatient(patientTest);
        appointment.setDoctor(doctorTest);
        appointment.setAppointmentDate(LocalDateTime.now().plusDays(1));
        appointment.setStatus(AppointmentStatus.PLANNED);
        Appointment saveAppointment = appointmentRepository.save(appointment);

        AppointmentResponseDTO responseDTO = appointmentService.updateAppointment(saveAppointment.getId(), AppointmentStatus.COMPLETED);

        assertEquals(AppointmentStatus.COMPLETED, responseDTO.getStatus());

        Appointment realAppointment = appointmentRepository.findById(saveAppointment.getId()).get();
        assertEquals(AppointmentStatus.COMPLETED, realAppointment.getStatus());
    }

    @Test
    void cancelAppointment() {
        Appointment appointment = new Appointment();
        appointment.setPatient(patientTest);
        appointment.setDoctor(doctorTest);
        appointment.setAppointmentDate(LocalDateTime.now().plusDays(3));
        appointment.setStatus(AppointmentStatus.PLANNED);
        Appointment saveAppointment = appointmentRepository.save(appointment);

        AppointmentResponseDTO responseDTO = appointmentService.cancelAppointment(saveAppointment.getId());

        assertEquals(AppointmentStatus.CANCELED, responseDTO.getStatus());
    }
}