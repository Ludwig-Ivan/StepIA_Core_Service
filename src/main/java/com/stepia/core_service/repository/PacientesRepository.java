package com.stepia.core_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepia.core_service.entity.Pacientes;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, String> {
}
