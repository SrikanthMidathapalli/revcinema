package com.revcinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revcinema.model.MovieEntity;
import com.revcinema.repository.MovieRepository;
import com.revcinema.dto.MovieDTO;
import com.revcinema.service.GenreService;
import com.revcinema.service.MovieService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private GenreService genreService;

    @Override
    public List<MovieDTO> findAllMovies() {
        return movieRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDTO> findMovieById(Long id) {
        return movieRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public MovieDTO saveMovie(MovieEntity movie) {
        MovieEntity savedMovie = movieRepository.save(movie);
        return convertToDTO(savedMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
    
    @Override
    public Optional<MovieEntity> findMovieEntityById(Long id) {
        return movieRepository.findById(id);
    }


    private MovieDTO convertToDTO(MovieEntity movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setGenreName(movie.getGenre().getName());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setCast(movie.getCast());
        movieDTO.setProduction(movie.getProduction());
        return movieDTO;
    }

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        MovieEntity movieEntity = convertToEntity(movieDTO);
        MovieEntity savedMovie = movieRepository.save(movieEntity);
        return convertToDTO(savedMovie);
    
}
    
    private MovieEntity convertToEntity(MovieDTO movieDTO) {
    	MovieEntity movie = new MovieEntity();
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(genreService.findByName(movieDTO.getGenreName())
                                   .orElseThrow(() -> new RuntimeException("Genre not found")));
        movie.setDescription(movieDTO.getDescription());
        movie.setCast(movieDTO.getCast());
        movie.setProduction(movieDTO.getProduction());
        return movie;
    }

}
