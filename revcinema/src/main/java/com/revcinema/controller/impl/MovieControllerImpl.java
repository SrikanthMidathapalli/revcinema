package com.revcinema.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revcinema.controller.MovieControllerInterface;
import com.revcinema.dto.MovieDTO;
import com.revcinema.service.MovieService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieControllerImpl implements MovieControllerInterface {
    @Autowired
    private MovieService movieService;

    @Override
    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.findAllMovies();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<MovieDTO> getMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody MovieDTO movie) {
        MovieDTO savedMovie = movieService.saveMovie(movie);
        return ResponseEntity.ok(savedMovie);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
}
