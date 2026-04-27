package com.healthcare.api.controller;

import com.healthcare.api.dto.DoctorRequestDTO;
import com.healthcare.api.dto.DoctorResponseDTO;
import com.healthcare.api.dto.DoctorRequestDTO;
import com.healthcare.api.dto.DoctorResponseDTO;
import com.healthcare.api.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {
    public final DoctorService doctorService;

    @PostMapping
    @Operation(summary = "Create new doctor")
    public ResponseEntity<DoctorResponseDTO> createdoctor(@Valid @RequestBody DoctorRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.createDoctor(dto));
    }

    @GetMapping
    @Operation(summary = "Get all doctors")
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update doctor infos")
    public ResponseEntity<DoctorResponseDTO> updateDoctor(@PathVariable Long id, @Valid @RequestBody DoctorRequestDTO dto) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a doctor")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
