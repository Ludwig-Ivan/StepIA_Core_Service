package com.stepia.core_service.controller;

import com.stepia.core_service.dto.expediente.*;
import com.stepia.core_service.service.ExpedienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expedientes")
public class ExpedienteController {

    private final ExpedienteService service;

    public ExpedienteController(
            ExpedienteService service) {
        this.service = service;
    }

    // =========================================================
    // POST
    // =========================================================

    @PostMapping
    public ResponseEntity<ExpedienteResponseDTO> crear(
            @Valid @RequestBody ExpedienteCreateDTO dto) {

        ExpedienteResponseDTO response = service.crear(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // =========================================================
    // GET ALL
    // =========================================================

    @GetMapping
    public ResponseEntity<List<ExpedienteResponseDTO>> obtenerTodos() {

        return ResponseEntity.ok(
                service.obtenerTodos());
    }

    // =========================================================
    // GET BY PACIENTE
    // =========================================================

    @GetMapping("/{idPaciente}")
    public ResponseEntity<ExpedienteResponseDTO> obtenerPorPaciente(
            @PathVariable String idPaciente) {

        return ResponseEntity.ok(
                service.obtenerPorPaciente(idPaciente));
    }

    // =========================================================
    // PUT
    // =========================================================

    @PutMapping("/{idPaciente}")
    public ResponseEntity<ExpedienteResponseDTO> actualizar(
            @PathVariable String idPaciente,
            @Valid @RequestBody ExpedienteUpdateDTO dto) {

        return ResponseEntity.ok(
                service.actualizar(idPaciente, dto));
    }

    @DeleteMapping("/{idExpediente}")
    public ResponseEntity<ExpedienteResponseDTO> delete(@PathVariable String idExpediente) {
        return ResponseEntity.ok(service.delete(idExpediente));
    }
}