package com.stepia.core_service.mapper;

import org.springframework.stereotype.Component;

import com.stepia.core_service.dto.analisis.AnalisisCreateDTO;
import com.stepia.core_service.dto.analisis.AnalisisResponseDTO;
import com.stepia.core_service.dto.analisis.AnalisisUpdateDTO;
import com.stepia.core_service.entity.Analisis;

@Component
public class AnalisisMapper {

    public Analisis toEntity(AnalisisCreateDTO request) {
        Analisis entity = new Analisis();
        entity.setIdInforme(request.getIdInforme());
        entity.setPieType(request.getPieType());
        entity.setClassName(request.getClassName());
        entity.setConfidence(request.getConfidence());
        return entity;
    }

    public void updateEntity(Analisis entity, AnalisisUpdateDTO request) {
        entity.setIdInforme(request.getIdInforme());
        entity.setPieType(request.getPieType());
        entity.setClassName(request.getClassName());
        entity.setConfidence(request.getConfidence());
    }

    public AnalisisResponseDTO toResponse(Analisis analisis) {
        AnalisisResponseDTO response = new AnalisisResponseDTO();
        response.setIdAnalisis(analisis.getIdAnalisis());
        response.setIdInforme(analisis.getIdInforme());
        response.setPieType(analisis.getPieType());
        response.setClassName(analisis.getClassName());
        response.setConfidence(analisis.getConfidence());
        response.setFechaRegistro(analisis.getFechaRegistro());
        response.setFechaActualizacion(analisis.getFechaActualizacion());
        return response;
    }
}
