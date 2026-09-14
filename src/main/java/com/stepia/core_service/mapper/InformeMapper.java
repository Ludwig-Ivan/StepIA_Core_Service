package com.stepia.core_service.mapper;

import com.stepia.core_service.dto.informe.InformeCreateUpdateDTO;
import com.stepia.core_service.dto.informe.InformeResponseDTO;
import com.stepia.core_service.entity.Informe;
import org.springframework.stereotype.Component;

@Component
public class InformeMapper {

    public Informe toEntity(InformeCreateUpdateDTO request) {

        Informe entity = new Informe();
        entity.setIdPaciente(request.getIdPaciente());
        entity.setIdProfesional(request.getIdProfesional());
        entity.setEstadoGeneral(request.getEstadoGeneral());
        entity.setPesoKg(request.getPesoKg());
        entity.setSintomas(request.getSintomas());
        entity.setDescripcion(request.getDescripcion());
        entity.setDiagnostico(request.getDiagnostico());
        entity.setCodigoCie10(request.getCodigoCie10());
        entity.setTratamiento(request.getTratamiento());
        entity.setEvolucion(request.getEvolucion());
        entity.setObservaciones(request.getObservaciones());

        return entity;
    }

    public void updateEntity(
            Informe entity,
            InformeCreateUpdateDTO request) {

        entity.setIdPaciente(request.getIdPaciente());
        entity.setIdProfesional(request.getIdProfesional());
        entity.setEstadoGeneral(request.getEstadoGeneral());
        entity.setPesoKg(request.getPesoKg());
        entity.setSintomas(request.getSintomas());
        entity.setDescripcion(request.getDescripcion());
        entity.setDiagnostico(request.getDiagnostico());
        entity.setCodigoCie10(request.getCodigoCie10());
        entity.setTratamiento(request.getTratamiento());
        entity.setEvolucion(request.getEvolucion());
        entity.setObservaciones(request.getObservaciones());
    }

    public InformeResponseDTO toResponse(Informe informe) {
        InformeResponseDTO response = new InformeResponseDTO();
        response.setIdInforme(informe.getIdInforme());
        response.setIdPaciente(informe.getIdPaciente());
        response.setIdProfesional(informe.getIdProfesional());
        response.setEstadoGeneral(informe.getEstadoGeneral());
        response.setPesoKg(informe.getPesoKg());
        response.setSintomas(informe.getSintomas());
        response.setDescripcion(informe.getDescripcion());
        response.setDiagnostico(informe.getDiagnostico());
        response.setCodigoCie10(informe.getCodigoCie10());
        response.setTratamiento(informe.getTratamiento());
        response.setEvolucion(informe.getEvolucion());
        response.setObservaciones(informe.getObservaciones());
        response.setFechaRegistro(informe.getFechaRegistro());
        return response;
    }
}