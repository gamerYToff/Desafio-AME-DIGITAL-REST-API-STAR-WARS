package com.br.star.repository;

import com.br.star.domain.model.Planeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetaRepository extends JpaRepository<Planeta, Long> {
    Planeta findByNome(String nome);
    boolean existsByNome(String nome);
}
