package com.healthcare.api.mapper;

import com.healthcare.api.dto.AppointmentRequestDTO;
import com.healthcare.api.dto.AppointmentResponseDTO;
import com.healthcare.api.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {

    @Mapping(target = "patient", ignore = true)
    @Mapping(target = "doctor", ignore = true)
    Appointment toEntity(AppointmentRequestDTO requestDTO);

    @Mapping(target = "doctorName", source = "doctor.name")
    @Mapping(target = "doctorSpecialty", source = "doctor.specialty")
    @Mapping(target = "patientCompleteName", expression = "java(entity.getPatient().getFirstName() + \" \" + entity.getPatient().getLastName())")
    AppointmentResponseDTO toResponseDTO(Appointment entity);
}
