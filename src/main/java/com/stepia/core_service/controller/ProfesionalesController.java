package com.stepia.core_service.controller;

import com.stepia.core_service.dto.profesional.ProfesionalCreateDTO;
import com.stepia.core_service.dto.profesional.ProfesionalResponseDTO;
import com.stepia.core_service.dto.profesional.ProfesionalUpdateDTO;
import com.stepia.core_service.service.ProfesionalService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesionales")
public class ProfesionalesController {

    private final ProfesionalService profesionalesService;

    public ProfesionalesController(
            ProfesionalService profesionalesService) {
        this.profesionalesService = profesionalesService;
    }

    // =========================================================
    // CREATE
    // POST /api/profesionales
    // =========================================================

    @PostMapping
    public ResponseEntity<ProfesionalResponseDTO> create(
            @Valid @RequestBody ProfesionalCreateDTO dto) {

        ProfesionalResponseDTO profesional = profesionalesService.create(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(profesional);
    }

    // =========================================================
    // READ ALL
    // GET /api/profesionales
    // =========================================================

    @GetMapping
    public ResponseEntity<List<ProfesionalResponseDTO>> findAll() {

        return ResponseEntity.ok(
                profesionalesService.findAll());
    }

    // =========================================================
    // READ ACTIVE
    // GET /api/profesionales/activos
    // =========================================================

    @GetMapping("/activos")
    public ResponseEntity<List<ProfesionalResponseDTO>> findAllActivos() {

        return ResponseEntity.ok(
                profesionalesService.findAllActivos());
    }

    // =========================================================
    // READ BY ID
    // GET /api/profesionales/{id}
    // =========================================================

    @GetMapping("/{id}")
    public ResponseEntity<ProfesionalResponseDTO> findById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                profesionalesService.findById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ProfesionalResponseDTO> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(profesionalesService.findByEmail(email));
    }

    // =========================================================
    // UPDATE
    // PUT /api/profesionales/{id}
    // =========================================================

    @PutMapping("/{id}")
    public ResponseEntity<ProfesionalResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ProfesionalUpdateDTO dto) {

        return ResponseEntity.ok(
                profesionalesService.update(id, dto));
    }

    // =========================================================
    // DELETE / DESACTIVAR
    // DELETE /api/profesionales/{id}
    // =========================================================

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        profesionalesService.delete(id);

        return ResponseEntity.noContent().build();
    }

    // =========================================================
    // REACTIVAR
    // PATCH /api/profesionales/{id}/reactivar
    // =========================================================

    @PatchMapping("/{id}/reactivar")
    public ResponseEntity<ProfesionalResponseDTO> reactivar(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                profesionalesService.reactivar(id));
    }
}