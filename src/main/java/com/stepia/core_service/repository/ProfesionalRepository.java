package com.stepia.core_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stepia.core_service.entity.Profesional;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    Optional<Profesional> findByEmail(String email);

    Optional<Profesional> findByCedulaProfesional(
            String cedulaProfesional);

    Optional<Profesional> findByCedulaEspecializada(
            String cedulaEspecializada);

    List<Profesional> findByActivoTrue();

    List<Profesional> findByActivoFalse();

    boolean existsByEmail(String email);

    boolean existsByCedulaProfesional(
            String cedulaProfesional);

    boolean existsByCedulaEspecializada(
            String cedulaEspecializada);
}