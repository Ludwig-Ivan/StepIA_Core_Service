package com.stepia.core_service.mapper;

import org.springframework.stereotype.Component;

import com.stepia.core_service.dto.pacientes.PacientesCreateDTO;
import com.stepia.core_service.dto.pacientes.PacientesResponseDTO;
import com.stepia.core_service.dto.pacientes.PacientesUpdateDTO;
import com.stepia.core_service.entity.Pacientes;

@Component
public class PacientesMapper {

    public Pacientes toEntity(PacientesCreateDTO createDTO) {
        Pacientes paciente = new Pacientes();
        paciente.setCurp(createDTO.getCurp());
        paciente.setNombre(createDTO.getNombre());
        paciente.setApellidoPaterno(createDTO.getApellidoPaterno());
        paciente.setApellidoMaterno(createDTO.getApellidoMaterno());
        paciente.setFechaNacimiento(createDTO.getFechaNacimiento());
        paciente.setSexo(createDTO.getSexo());
        paciente.setTelefono(createDTO.getTelefono());
        paciente.setDomicilio(createDTO.getDomicilio());
        return paciente;
    }

    public void UpdateEntity(Pacientes paciente, PacientesUpdateDTO updateDTO) {
        paciente.setNombre(updateDTO.getNombre());
        paciente.setApellidoPaterno(updateDTO.getApellidoPaterno());
        paciente.setApellidoMaterno(updateDTO.getApellidoMaterno());
        paciente.setFechaNacimiento(updateDTO.getFechaNacimiento());
        paciente.setSexo(updateDTO.getSexo());
        paciente.setTelefono(updateDTO.getTelefono());
        paciente.setDomicilio(updateDTO.getDomicilio());
    }

    public PacientesResponseDTO toResponseDTO(Pacientes paciente) {
        PacientesResponseDTO responseDTO = new PacientesResponseDTO();
        responseDTO.setCurp(paciente.getCurp());
        responseDTO.setNombre(paciente.getNombre());
        responseDTO.setApellidoPaterno(paciente.getApellidoPaterno());
        responseDTO.setApellidoMaterno(paciente.getApellidoMaterno());
        responseDTO.setFechaNacimiento(paciente.getFechaNacimiento());
        responseDTO.setSexo(paciente.getSexo());
        responseDTO.setTelefono(paciente.getTelefono());
        responseDTO.setDomicilio(paciente.getDomicilio());
        return responseDTO;
    }
}
