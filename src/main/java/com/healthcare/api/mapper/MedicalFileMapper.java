package com.healthcare.api.mapper;

import com.healthcare.api.dto.MedicalFileRequestDTO;
import com.healthcare.api.dto.MedicalFileResponseDTO;
import com.healthcare.api.entity.MedicalFile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MedicalFileMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    @Mapping(target = "patient", ignore = true)
    MedicalFile toEntity(MedicalFileRequestDTO requestDTO);

    @Mapping(target = "patientId", source = "patient.id")
    @Mapping(target = "patientCompleteName", expression = "java(entity.getPatient().getFirstName() + ' ' + entity.getPatient().getLastName())")
    MedicalFileResponseDTO toResponseDTO(MedicalFile entity);
}
