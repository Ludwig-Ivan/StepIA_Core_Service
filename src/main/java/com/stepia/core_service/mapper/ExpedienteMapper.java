package com.stepia.core_service.mapper;

import com.stepia.core_service.dto.expediente.ExpedienteCreateDTO;
import com.stepia.core_service.dto.expediente.ExpedienteResponseDTO;
import com.stepia.core_service.dto.expediente.ExpedienteUpdateDTO;
import com.stepia.core_service.entity.Expediente;
import org.springframework.stereotype.Component;

@Component
public class ExpedienteMapper {

    // =========================================================
    // CREATE DTO -> ENTITY
    // =========================================================

    public Expediente toEntity(
            ExpedienteCreateDTO dto) {

        Expediente entity = new Expediente();

        entity.setIdPaciente(dto.getIdPaciente());
        entity.setNumeroExpediente(dto.getNumeroExpediente());
        entity.setAntecedentes(dto.getAntecedentes());
        entity.setEstado(dto.getEstado());

        return entity;
    }

    // =========================================================
    // UPDATE DTO -> ENTITY
    // =========================================================

    public void updateEntity(
            Expediente entity,
            ExpedienteUpdateDTO dto) {

        entity.setNumeroExpediente(dto.getNumeroExpediente());
        entity.setAntecedentes(dto.getAntecedentes());
        entity.setEstado(dto.getEstado());
    }

    // =========================================================
    // ENTITY -> RESPONSE DTO
    // =========================================================

    public ExpedienteResponseDTO toResponseDTO(
            Expediente entity) {

        ExpedienteResponseDTO dto = new ExpedienteResponseDTO();

        dto.setIdPaciente(entity.getIdPaciente());
        dto.setNumeroExpediente(entity.getNumeroExpediente());
        dto.setAntecedentes(entity.getAntecedentes());
        dto.setEstado(entity.getEstado());

        return dto;
    }
}
