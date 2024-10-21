package com.revcinema.service;

import com.revcinema.dto.GenreDTO;
import com.revcinema.model.GenreEntity;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<GenreDTO> findAllGenres();
    Optional<GenreDTO> findGenreById(Long id);
    GenreDTO saveGenre(GenreDTO genre);
    void deleteGenre(Long id);
	GenreDTO saveGenre(GenreEntity genre);
	Optional<GenreEntity> findByName(String name);
}
