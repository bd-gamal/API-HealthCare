package com.healthcare.api.controller;

import com.healthcare.api.dto.MedicalFileRequestDTO;
import com.healthcare.api.dto.MedicalFileResponseDTO;
import com.healthcare.api.dto.MedicalFileResponseDTO;
import com.healthcare.api.service.MedicalFileService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class MedicalFileController {
    private final MedicalFileService medicalFileService;

    @PostMapping
    @Operation(summary = "Create new medical file for patient")
    public ResponseEntity<MedicalFileResponseDTO> createMedicalFile(@Valid @RequestBody MedicalFileRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicalFileService.createFile(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get file by ID")
    public ResponseEntity<MedicalFileResponseDTO> getMedicalFileById(@PathVariable Long id) {
        return ResponseEntity.ok(medicalFileService.getFileByPatientId(id));
    }

    @PatchMapping("/{id}/notes")
    @Operation(summary = "Add diagnosis or observation")
    public ResponseEntity<MedicalFileResponseDTO> updateNotes(@PathVariable Long id, @RequestParam String observation, @RequestParam String diagnosis) {
        return ResponseEntity.ok(medicalFileService.addObservationAndDiagnosis(id, observation, diagnosis));
    }

}
