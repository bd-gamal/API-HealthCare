package com.healthcare.api.service;

import com.healthcare.api.dto.PatientRequestDTO;
import com.healthcare.api.dto.PatientResponseDTO;
import com.healthcare.api.entity.Patient;
import com.healthcare.api.mapper.PatientMapper;
import com.healthcare.api.repository.PatientRepository;
import org.springframework.cache.annotation.CacheEvict;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Transactional
    @CacheEvict(value = "patients", allEntries = true)
    public PatientResponseDTO createPatient(PatientRequestDTO dto) {
        if (patientRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("A patient with this email already exists !");
        }

        Patient patient = patientMapper.toEntity(dto);
        Patient savePatient = patientRepository.save(patient);
        return patientMapper.toResponseDTO(savePatient);
    }

    @Transactional
    @Cacheable(value = "patients")
    public Page<PatientResponseDTO> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable).map(patientMapper::toResponseDTO);
    }

    @Transactional
    public Page<PatientResponseDTO> searchPatientByName(String name, Pageable pageable) {
        return patientRepository.findByLastNameContainingIgnoreCase(name, pageable).map(patientMapper::toResponseDTO);
    }

    @Transactional
    public PatientResponseDTO getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("This patient doesn't exist"));
        return patientMapper.toResponseDTO(patient);
    }

    @Transactional
    @CacheEvict(value = "patients", allEntries = true)
    public PatientResponseDTO updatePatient(Long id, PatientRequestDTO dto) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("This patient doesn't exist"));

        patient.setLastName(dto.getLastName());
        patient.setFirstName(dto.getFirstName());
        patient.setEmail(dto.getEmail());
        patient.setPhone(dto.getPhone());
        patient.setBirthDate(dto.getBirthDate());

        Patient updatePatient = patientRepository.save(patient);
        return patientMapper.toResponseDTO(updatePatient);
    }

    @Transactional
    @CacheEvict(value = "patients", allEntries = true)
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with the ID : " + id);
        }
        patientRepository.deleteById(id);
    }
}
