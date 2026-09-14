package com.stepia.core_service.service;

import com.stepia.core_service.dto.expediente.*;
import com.stepia.core_service.entity.Expediente;
import com.stepia.core_service.mapper.ExpedienteMapper;
import com.stepia.core_service.repository.ExpedienteRepository;
import com.stepia.core_service.service.ExpedienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class ExpedienteService {

        private final ExpedienteRepository repository;
        private final ExpedienteMapper mapper;

        public ExpedienteService(
                        ExpedienteRepository repository,
                        ExpedienteMapper mapper) {
                this.repository = repository;
                this.mapper = mapper;
        }

        // =========================================================
        // CREATE
        // =========================================================

        public ExpedienteResponseDTO crear(
                        ExpedienteCreateDTO dto) {

                if (repository.existsById(dto.getIdPaciente())) {
                        throw new IllegalArgumentException(
                                        "El paciente ya tiene un expediente clínico");
                }

                if (repository.existsByNumeroExpediente(
                                dto.getNumeroExpediente())) {
                        throw new IllegalArgumentException(
                                        "El número de expediente ya está registrado");
                }

                Expediente entity = mapper.toEntity(dto);

                Expediente guardado = repository.save(entity);

                return mapper.toResponseDTO(guardado);
        }

        // =========================================================
        // GET BY PACIENTE
        // =========================================================

        @Transactional(readOnly = true)
        public ExpedienteResponseDTO obtenerPorPaciente(String idPaciente) {

                Expediente entity = repository.findById(idPaciente)
                                .orElseThrow(() -> new IllegalArgumentException(
                                                "No existe un expediente para el paciente: "
                                                                + idPaciente));

                return mapper.toResponseDTO(entity);
        }

        // =========================================================
        // GET ALL
        // =========================================================

        @Transactional(readOnly = true)
        public List<ExpedienteResponseDTO> obtenerTodos() {

                return repository.findAll()
                                .stream()
                                .map(mapper::toResponseDTO)
                                .toList();
        }

        // =========================================================
        // UPDATE
        // =========================================================

        public ExpedienteResponseDTO actualizar(
                        String idPaciente,
                        ExpedienteUpdateDTO dto) {

                Expediente entity = repository.findById(idPaciente)
                                .orElseThrow(() -> new IllegalArgumentException(
                                                "No existe un expediente para el paciente: "
                                                                + idPaciente));

                // Verificar que el número no pertenezca
                // a otro expediente.

                repository.findByNumeroExpediente(
                                dto.getNumeroExpediente()).ifPresent(expediente -> {

                                        if (!expediente.getIdPaciente()
                                                        .equals(idPaciente)) {

                                                throw new IllegalArgumentException(
                                                                "El número de expediente ya está registrado");
                                        }
                                });

                mapper.updateEntity(entity, dto);

                Expediente actualizado = repository.save(entity);

                return mapper.toResponseDTO(actualizado);
        }

        public ExpedienteResponseDTO delete(String idExpediente) {
                Expediente exp = repository.findById(idExpediente).orElseThrow(() -> new IllegalArgumentException(
                                "No existe este expediente: "
                                                + idExpediente));
                repository.delete(exp);
                return mapper.toResponseDTO(exp);
        }
}