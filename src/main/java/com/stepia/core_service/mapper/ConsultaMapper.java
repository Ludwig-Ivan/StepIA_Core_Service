package com.stepia.core_service.mapper;

import org.springframework.stereotype.Component;

import com.stepia.core_service.dto.consulta.ConsultaCreateDTO;
import com.stepia.core_service.dto.consulta.ConsultaResponseDTO;
import com.stepia.core_service.dto.consulta.ConsultaUpdateDTO;
import com.stepia.core_service.entity.Consulta;

@Component
public class ConsultaMapper {

    public Consulta toEntity(ConsultaCreateDTO dto) {
        Consulta entity = new Consulta();

        entity.setIdPaciente(dto.getIdPaciente());
        entity.setEstado(dto.getEstado());
        entity.setIdProfesional(dto.getIdProfesional());
        entity.setFechaHora(dto.getFechaHora());
        entity.setMotivo(dto.getMotivo());
        entity.setObservaciones(dto.getObservaciones());
        entity.setConsultaOrigen(dto.getIdConsultaOrigen());

        return entity;
    }

    public void updateEntity(Consulta entity, ConsultaUpdateDTO dto) {
        entity.setIdProfesional(dto.getIdProfesional());
        entity.setFechaHora(dto.getFechaHora());
        entity.setEstado(dto.getEstado());
        entity.setMotivo(dto.getMotivo());
        entity.setObservaciones(dto.getObservaciones());
    }

    public ConsultaResponseDTO toResponseDTO(Consulta entity) {

        ConsultaResponseDTO dto = new ConsultaResponseDTO();

        dto.setIdConsulta(entity.getIdConsulta());
        dto.setIdPaciente(entity.getIdPaciente());
        dto.setIdProfesional(entity.getIdProfesional());
        dto.setFechaHora(entity.getFechaHora());
        dto.setEstado(entity.getEstado());
        dto.setMotivo(entity.getMotivo());
        dto.setObservaciones(entity.getObservaciones());
        dto.setIdConsultaOrigen(entity.getConsultaOrigen());
        dto.setFechaCreacion(entity.getFechaCreacion());
        dto.setFechaActualizacion(entity.getFechaActualizacion());

        return dto;
    }
}
