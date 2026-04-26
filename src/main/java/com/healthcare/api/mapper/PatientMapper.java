package com.healthcare.api.mapper;

import com.healthcare.api.dto.PatientRequestDTO;
import com.healthcare.api.dto.PatientResponseDTO;
import com.healthcare.api.entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toEntity(PatientRequestDTO requestDTO);

    PatientResponseDTO toResponseDTO(Patient entity);
}
