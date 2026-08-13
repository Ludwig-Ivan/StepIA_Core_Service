package com.stepia.core_service.mapper;

import com.stepia.core_service.dto.profesional.ProfesionalCreateDTO;
import com.stepia.core_service.dto.profesional.ProfesionalResponseDTO;
import com.stepia.core_service.dto.profesional.ProfesionalUpdateDTO;
import com.stepia.core_service.entity.Profesional;
import org.springframework.stereotype.Component;

@Component
public class ProfesionalMapper {

        public Profesional toEntity(ProfesionalCreateDTO dto) {

                Profesional profesional = new Profesional();

                profesional.setEspecialidad(dto.getEspecialidad());
                profesional.setNombre(dto.getNombre());
                profesional.setApellidoPaterno(dto.getApellidoPaterno());
                profesional.setApellidoMaterno(dto.getApellidoMaterno());
                profesional.setCedulaProfesional(dto.getCedulaProfesional());
                profesional.setCedulaEspecializada(dto.getCedulaEspecializada());
                profesional.setInstitucion(dto.getInstitucion());
                profesional.setTelefono(dto.getTelefono());
                profesional.setEmail(dto.getEmail());

                profesional.setActivo(true);

                return profesional;
        }

        public void updateEntity(
                        Profesional profesional,
                        ProfesionalUpdateDTO dto) {

                profesional.setEspecialidad(dto.getEspecialidad());
                profesional.setNombre(dto.getNombre());
                profesional.setApellidoPaterno(dto.getApellidoPaterno());
                profesional.setApellidoMaterno(dto.getApellidoMaterno());
                profesional.setCedulaProfesional(dto.getCedulaProfesional());
                profesional.setCedulaEspecializada(dto.getCedulaEspecializada());
                profesional.setInstitucion(dto.getInstitucion());
                profesional.setTelefono(dto.getTelefono());
                profesional.setEmail(dto.getEmail());
        }

        public ProfesionalResponseDTO toResponseDTO(
                        Profesional profesional) {

                ProfesionalResponseDTO dto = new ProfesionalResponseDTO();

                dto.setIdProfesional(
                                profesional.getIdProfesional());

                dto.setEspecialidad(
                                profesional.getEspecialidad());

                dto.setNombre(
                                profesional.getNombre());

                dto.setApellidoPaterno(
                                profesional.getApellidoPaterno());

                dto.setApellidoMaterno(
                                profesional.getApellidoMaterno());

                dto.setCedulaProfesional(
                                profesional.getCedulaProfesional());

                dto.setCedulaEspecializada(
                                profesional.getCedulaEspecializada());

                dto.setInstitucion(
                                profesional.getInstitucion());

                dto.setTelefono(
                                profesional.getTelefono());

                dto.setEmail(
                                profesional.getEmail());

                dto.setActivo(
                                profesional.getActivo());

                return dto;
        }
}