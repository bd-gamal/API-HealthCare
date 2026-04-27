package com.healthcare.api.service;

import com.healthcare.api.dto.MedicalFileRequestDTO;
import com.healthcare.api.dto.MedicalFileResponseDTO;
import com.healthcare.api.entity.MedicalFile;
import com.healthcare.api.entity.Patient;
import com.healthcare.api.mapper.MedicalFileMapper;
import com.healthcare.api.repository.MedicalFileRepository;
import com.healthcare.api.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalFileService {
    private final MedicalFileRepository medicalFileRepository;
    private final PatientRepository patientRepository;
    private final MedicalFileMapper medicalFileMapper;

    @Transactional
    public MedicalFileResponseDTO createFile(MedicalFileRequestDTO dto) {
        Patient patient = patientRepository.findById(dto.getPatientId()).orElseThrow(() -> new RuntimeException("Patient not found"));
        if (medicalFileRepository.existsByPatientId(patient.getId())) {
            throw new IllegalStateException("This patient already has a medical file");
        }

        MedicalFile file = medicalFileMapper.toEntity(dto);
        file.setPatient(patient);

        MedicalFile savedFile = medicalFileRepository.save(file);
        return medicalFileMapper.toResponseDTO(savedFile);
    }

    @Transactional
    public MedicalFileResponseDTO getFileByPatientId(Long patientId) {
        MedicalFile file = medicalFileRepository.findByPatientId(patientId).orElseThrow(() -> new RuntimeException("No file were found for this patient ID : " + patientId));
        return medicalFileMapper.toResponseDTO(file);
    }

    @Transactional
    public MedicalFileResponseDTO addObservationAndDiagnosis(Long fileId, String observation, String diagnosis) {
        MedicalFile file = medicalFileRepository.findById(fileId).orElseThrow(() -> new RuntimeException("File not found"));
        if (observation != null) {
            file.setObservation(file.getObservation());
        }
        if (diagnosis != null) {
            file.setDiagnosis(file.getDiagnosis());
        }
        return medicalFileMapper.toResponseDTO(medicalFileRepository.save(file));
    }
}
