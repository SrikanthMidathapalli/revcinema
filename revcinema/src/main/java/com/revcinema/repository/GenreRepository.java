package com.revcinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revcinema.model.GenreEntity;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<GenreEntity, Long> {
    Optional<GenreEntity> findByName(String name);
}
