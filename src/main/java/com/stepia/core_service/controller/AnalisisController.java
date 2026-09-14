package com.stepia.core_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stepia.core_service.dto.analisis.AnalisisCreateDTO;
import com.stepia.core_service.dto.analisis.AnalisisResponseDTO;
import com.stepia.core_service.dto.analisis.AnalisisUpdateDTO;
import com.stepia.core_service.service.AnalisisService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/analisis")
public class AnalisisController {
    private final AnalisisService service;

    public AnalisisController(AnalisisService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity<AnalisisResponseDTO> postMethodName(@Valid @RequestBody AnalisisCreateDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnalisisResponseDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findByIdAnalisis(id));
    }

    @GetMapping("/informe/{id}")
    public ResponseEntity<List<AnalisisResponseDTO>> findByIdInforme(@PathVariable UUID id) {
        return ResponseEntity.ok(service.findByIdInforme(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnalisisResponseDTO> update(@PathVariable UUID id, @RequestBody AnalisisUpdateDTO request) {
        return ResponseEntity.ok(service.update(id, request));
    }
}
