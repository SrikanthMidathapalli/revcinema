package com.revcinema.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revcinema.controller.GenreControllerInterface;
import com.revcinema.dto.GenreDTO;
import com.revcinema.service.GenreService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
public class GenreControllerImpl implements GenreControllerInterface {
    @Autowired
    private GenreService genreService;

    @Override
    @GetMapping
    public List<GenreDTO> getAllGenres() {
        return genreService.findAllGenres();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<GenreDTO> getGenreById(@PathVariable Long id) {
        return genreService.findGenreById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<GenreDTO> createGenre(@Valid @RequestBody GenreDTO genre) {
        GenreDTO savedGenre = genreService.saveGenre(genre);
        return ResponseEntity.ok(savedGenre);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
    }
}
