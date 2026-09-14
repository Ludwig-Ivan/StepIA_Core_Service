package com.stepia.core_service.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.stepia.core_service.dto.pacientes.PacientesCreateDTO;
import com.stepia.core_service.dto.pacientes.PacientesResponseDTO;
import com.stepia.core_service.dto.pacientes.PacientesUpdateDTO;
import com.stepia.core_service.entity.Pacientes;
import com.stepia.core_service.mapper.PacientesMapper;
import com.stepia.core_service.repository.PacientesRepository;

@Service
public class PacientesService {
    private final PacientesRepository pacientesRepository;
    private final PacientesMapper pacientesMapper;

    public PacientesService(PacientesRepository pacientesRepository, PacientesMapper pacientesMapper) {
        this.pacientesRepository = pacientesRepository;
        this.pacientesMapper = pacientesMapper;
    }

    public PacientesResponseDTO createPaciente(PacientesCreateDTO pacientesCreateDTO) {

        if (pacientesRepository.existsById(pacientesCreateDTO.getCurp())) {
            throw new IllegalArgumentException(
                    "Ya existe un paciente con la CURP proporcionada");
        }

        Pacientes paciente = pacientesMapper.toEntity(pacientesCreateDTO);
        Pacientes savedPaciente = pacientesRepository.save(paciente);
        return pacientesMapper.toResponseDTO(savedPaciente);
    }

    @Transactional(readOnly = true)
    public PacientesResponseDTO getPacienteById(String curp) {
        Pacientes paciente = pacientesRepository.findById(curp)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con CURP: " + curp));
        return pacientesMapper.toResponseDTO(paciente);
    }

    @Transactional(readOnly = true)
    public List<PacientesResponseDTO> getAllPacientes() {
        List<Pacientes> pacientes = pacientesRepository.findAll();
        return pacientes.stream()
                .map(pacientesMapper::toResponseDTO)
                .toList();
    }

    public Page<PacientesResponseDTO> buscarPacientes(String search, Pageable pageable) {
        Page<Pacientes> pacientes;

        if (search == null || search.isBlank()) {

            pacientes = pacientesRepository.findAll(pageable);

        } else {

            pacientes = pacientesRepository
                    .findByNombreContainingIgnoreCaseOrApellidoPaternoContainingIgnoreCaseOrApellidoMaternoContainingIgnoreCaseOrCurpContaining(
                            search, search, search, search, pageable);
        }

        return pacientes.map(pacientesMapper::toResponseDTO);
    }

    public PacientesResponseDTO updatePaciente(String curp, PacientesUpdateDTO pacientesUpdateDTO) {
        Pacientes paciente = pacientesRepository.findById(curp)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con CURP: " + curp));

        pacientesMapper.UpdateEntity(paciente, pacientesUpdateDTO);
        Pacientes updatedPaciente = pacientesRepository.save(paciente);
        return pacientesMapper.toResponseDTO(updatedPaciente);
    }

    public PacientesResponseDTO deletePaciente(String curp) {
        Pacientes paciente = pacientesRepository.findById(curp)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con CURP: " + curp));

        pacientesRepository.delete(paciente);
        return pacientesMapper.toResponseDTO(paciente);
    }
}
