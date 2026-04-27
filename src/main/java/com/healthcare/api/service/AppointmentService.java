package com.healthcare.api.service;

import com.healthcare.api.dto.AppointmentRequestDTO;
import com.healthcare.api.dto.AppointmentResponseDTO;
import com.healthcare.api.entity.Appointment;
import com.healthcare.api.entity.AppointmentStatus;
import com.healthcare.api.entity.Doctor;
import com.healthcare.api.entity.Patient;
import com.healthcare.api.mapper.AppointmentMapper;
import com.healthcare.api.repository.AppointmentRepository;
import com.healthcare.api.repository.DoctorRepository;
import com.healthcare.api.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentMapper appointmentMapper;

    @Transactional
    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId()).orElseThrow(() -> new RuntimeException("Patient not found"));
        Doctor doctor = doctorRepository.findById(dto.getDoctorId()).orElseThrow(() -> new RuntimeException("Doctor not found"));
        Appointment appointment = appointmentMapper.toEntity(dto);
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setStatus(AppointmentStatus.PLANNED);

        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toResponseDTO(savedAppointment);
    }

    @Transactional
    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream().map(appointmentMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional
    public List<AppointmentResponseDTO> getAppointmentByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId).stream().map(appointmentMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional
    public List<AppointmentResponseDTO> getAppointmentByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId).stream().map(appointmentMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional
    public AppointmentResponseDTO updateAppointment(Long id, AppointmentStatus status) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found"));
        appointment.setStatus(status);
        return appointmentMapper.toResponseDTO(appointmentRepository.save(appointment));
    }

    @Transactional
    public AppointmentResponseDTO cancelAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Appointment not found with ID : " + id));
        if (appointment.getStatus() == AppointmentStatus.COMPLETED) {
            throw new IllegalStateException("Can't cancel appointment already completed");
        }

        appointment.setStatus(AppointmentStatus.CANCELED);

        Appointment saveAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toResponseDTO(saveAppointment);
    }
}
