package com.revcinema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.revcinema.dto.MovieDTO;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface MovieControllerInterface {
    List<MovieDTO> getAllMovies();

    Optional<MovieDTO> getMovieById(@PathVariable Long id);

    ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody MovieDTO movie);

    void deleteMovie(@PathVariable Long id);
}
