package com.healthcare.api.mapper;

import com.healthcare.api.dto.DoctorRequestDTO;
import com.healthcare.api.dto.DoctorResponseDTO;
import com.healthcare.api.entity.Doctor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor toEntity(DoctorRequestDTO requestDTO);

    DoctorResponseDTO toResponseDTO(Doctor entity);
}
