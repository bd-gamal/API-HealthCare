package com.healthcare.api.repository;

import com.healthcare.api.entity.MedicalFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalFileRepository extends JpaRepository<MedicalFile, Long> {

    @EntityGraph(attributePaths = {"patient"})
    Optional<MedicalFile> findByPatientId(Long patientId);

    @EntityGraph(attributePaths = {"patient"})
    Page<MedicalFile> findAll(Pageable pageable);

    boolean existsByPatientId(Long patientId);
}
