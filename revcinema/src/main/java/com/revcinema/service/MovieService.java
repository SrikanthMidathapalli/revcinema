package com.revcinema.service;

import com.revcinema.dto.MovieDTO;
import com.revcinema.model.MovieEntity;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDTO> findAllMovies();
    Optional<MovieDTO> findMovieById(Long id);
    MovieDTO saveMovie(MovieDTO movie);
    void deleteMovie(Long id);
	MovieDTO saveMovie(MovieEntity movie);
    Optional<MovieEntity> findMovieEntityById(Long id);  // Method to find movie by ID

}
