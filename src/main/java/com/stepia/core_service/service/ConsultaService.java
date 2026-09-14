package com.stepia.core_service.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stepia.core_service.dto.consulta.ConsultaCreateDTO;
import com.stepia.core_service.dto.consulta.ConsultaResponseDTO;
import com.stepia.core_service.dto.consulta.ConsultaUpdateDTO;
import com.stepia.core_service.entity.Consulta;
import com.stepia.core_service.mapper.ConsultaMapper;
import com.stepia.core_service.repository.ConsultaRepository;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;
    private final ConsultaMapper mapper;

    public ConsultaService(
            ConsultaRepository repository,
            ConsultaMapper mapper) {

        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public ConsultaResponseDTO crearConsulta(ConsultaCreateDTO dto) {

        if (dto.getIdConsultaOrigen() != null)
            repository.findById(dto.getIdConsultaOrigen())
                    .orElseThrow(() -> new RuntimeException("Consulta origen no encontrada"));

        Consulta consulta = mapper.toEntity(dto);

        return mapper.toResponseDTO(repository.save(consulta));
    }

    @Transactional(readOnly = true)
    public ConsultaResponseDTO obtenerPorId(Long id) {

        Consulta consulta = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Consulta no encontrada"));

        return mapper.toResponseDTO(consulta);
    }

    @Transactional(readOnly = true)
    public List<ConsultaResponseDTO> obtenerPorPaciente(String curp) {

        return repository.findByIdPaciente(curp)
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }

    @Transactional
    public ConsultaResponseDTO actualizarConsulta(Long id, ConsultaUpdateDTO dto) {

        Consulta consulta = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Consulta no encontrada"));

        mapper.updateEntity(consulta, dto);

        return mapper.toResponseDTO(
                repository.save(consulta));
    }

    @Transactional
    public ConsultaResponseDTO cambiarEstado(
            Long id,
            String estado) {

        Consulta consulta = repository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Consulta no encontrada"));

        consulta.setEstado(estado);

        return mapper.toResponseDTO(
                repository.save(consulta));
    }
}