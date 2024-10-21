package com.revcinema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.revcinema.dto.GenreDTO;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface GenreControllerInterface {
    List<GenreDTO> getAllGenres();

    Optional<GenreDTO> getGenreById(@PathVariable Long id);

    ResponseEntity<GenreDTO> createGenre(@Valid @RequestBody GenreDTO genre);

    void deleteGenre(@PathVariable Long id);
}
