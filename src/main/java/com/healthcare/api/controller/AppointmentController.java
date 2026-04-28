package com.healthcare.api.controller;

import com.healthcare.api.dto.*;
import com.healthcare.api.entity.AppointmentStatus;
import com.healthcare.api.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @PostMapping
    @Operation(summary = "Create new appointment for appointment")
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@Valid @RequestBody AppointmentRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.createAppointment(dto));
    }

    @GetMapping
    @Operation(summary = "Get all appointments")
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/doctor/{doctorId}")
    @Operation(summary = "Search appointments by doctor")
    public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        return ResponseEntity.ok(appointmentService.getAppointmentByDoctor(doctorId));
    }

    @GetMapping("/patient/{patientId}")
    @Operation(summary = "Search appointments by patient")
    public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentsByPatient(@PathVariable Long patientId) {
        return ResponseEntity.ok(appointmentService.getAppointmentByPatient(patientId));
    }

    @PutMapping("/cancel/{id}")
    @Operation(summary = "Cancel appointment")
    public ResponseEntity<AppointmentResponseDTO> cancelAppointment(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(id));
    }

    @PatchMapping("/{id}/status")
    @Operation(summary = "Update appointment status")
    public ResponseEntity<AppointmentResponseDTO> updateAppointmentStatus(@PathVariable Long id, @RequestParam AppointmentStatus status) {
        AppointmentResponseDTO updatedAppointment = appointmentService.updateAppointment(id, status);
        return ResponseEntity.ok(updatedAppointment);
    }
}