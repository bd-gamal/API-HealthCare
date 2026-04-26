package com.healthcare.api.repository;

import com.healthcare.api.entity.MedicalFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalFileRepository extends JpaRepository<MedicalFile, Long> {

    Optional<MedicalFile> findByPatientId(Long patientId);

    boolean existsByPatientId(Long patientId);
}
