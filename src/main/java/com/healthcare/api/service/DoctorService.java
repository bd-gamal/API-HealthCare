package com.healthcare.api.service;

import com.healthcare.api.dto.DoctorRequestDTO;
import com.healthcare.api.dto.DoctorResponseDTO;
import com.healthcare.api.dto.PatientRequestDTO;
import com.healthcare.api.dto.PatientResponseDTO;
import com.healthcare.api.entity.Doctor;
import com.healthcare.api.entity.Patient;
import com.healthcare.api.mapper.DoctorMapper;
import com.healthcare.api.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Transactional
    public DoctorResponseDTO createDoctor(DoctorRequestDTO dto) {
        Doctor doctor = doctorMapper.toEntity(dto);
        return doctorMapper.toResponseDTO(doctorRepository.save(doctor));
    }

    @Transactional
    public List<DoctorResponseDTO> getAllDoctors() {
        return doctorRepository.findAll().stream().map(doctorMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional
    public DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO dto) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow(() -> new RuntimeException("This doctor doesn't exist"));

        doctor.setName(dto.getName());
        doctor.setSpecialty(dto.getSpecialty());
        doctor.setEmail(dto.getEmail());
        doctor.setPhone(dto.getPhone());

        Doctor updateDoctor = doctorRepository.save(doctor);
        return doctorMapper.toResponseDTO(updateDoctor);
    }

    @Transactional
    public void deleteDoctor(Long id) {
        if (!doctorRepository.existsById(id)) {
            throw new RuntimeException("Patient not found with the ID : " + id);
        }
        doctorRepository.deleteById(id);
    }
}
