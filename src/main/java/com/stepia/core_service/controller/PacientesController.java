package com.stepia.core_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stepia.core_service.dto.pacientes.PacientesCreateDTO;
import com.stepia.core_service.dto.pacientes.PacientesResponseDTO;
import com.stepia.core_service.dto.pacientes.PacientesUpdateDTO;
import com.stepia.core_service.service.PacientesService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {
    private final PacientesService pacientesService;

    public PacientesController(PacientesService pacientesService) {
        this.pacientesService = pacientesService;
    }

    @PostMapping
    public ResponseEntity<PacientesResponseDTO> createPaciente(
            @Valid @RequestBody PacientesCreateDTO pacientesCreateDTO) {
        PacientesResponseDTO response = pacientesService.createPaciente(pacientesCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // @GetMapping
    // public ResponseEntity<List<PacientesResponseDTO>> getAllPacientes() {
    // return ResponseEntity.ok(pacientesService.getAllPacientes());
    // }

    @GetMapping
    public ResponseEntity<Page<PacientesResponseDTO>> buscarPacientes(
            @RequestParam(required = false, defaultValue = "") String search,
            @PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(pacientesService.buscarPacientes(search, pageable));
    }

    @GetMapping("/{curp}")
    public ResponseEntity<PacientesResponseDTO> getPacienteById(
            @PathVariable String curp) {

        return ResponseEntity.ok(
                pacientesService.getPacienteById(curp));
    }

    @PutMapping("/{curp}")
    public ResponseEntity<PacientesResponseDTO> updatePaciente(
            @PathVariable String curp,
            @Valid @RequestBody PacientesUpdateDTO request) {

        return ResponseEntity.ok(
                pacientesService.updatePaciente(curp, request));
    }

    @DeleteMapping("/{curp}")
    public ResponseEntity<PacientesResponseDTO> deletePaciente(@PathVariable String curp) {
        return ResponseEntity.ok(pacientesService.deletePaciente(curp));
    }
}
