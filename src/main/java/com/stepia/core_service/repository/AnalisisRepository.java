package com.stepia.core_service.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.stepia.core_service.entity.Analisis;

public interface AnalisisRepository extends JpaRepository<Analisis, UUID> {
    Analisis findByIdAnalisis(UUID idAnalisis);

    List<Analisis> findByIdInforme(UUID idInforme);

}
