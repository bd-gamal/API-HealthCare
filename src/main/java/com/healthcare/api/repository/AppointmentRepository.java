package com.healthcare.api.repository;

import com.healthcare.api.entity.Appointment;
import com.healthcare.api.entity.AppointmentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @EntityGraph(attributePaths = {"patient", "doctor"})
    Page<Appointment> findAll(Pageable pageable);

    @EntityGraph(attributePaths = {"patient", "doctor"})
    Page<Appointment> findByPatientId(Long patientId, Pageable pageable);

    @EntityGraph(attributePaths = {"patient", "doctor"})
    Page<Appointment> findByDoctorId(Long doctorId, Pageable pageable);

    @EntityGraph(attributePaths = {"patient", "doctor"})
    Page<Appointment> findByStatus(AppointmentStatus status, Pageable pageable);

}
