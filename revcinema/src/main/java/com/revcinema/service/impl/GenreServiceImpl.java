package com.revcinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revcinema.model.GenreEntity;
import com.revcinema.repository.GenreRepository;
import com.revcinema.dto.GenreDTO;
import com.revcinema.service.GenreService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreServiceImpl implements GenreService {
    @Autowired
    private GenreRepository genreRepository;

    @Override
    public List<GenreDTO> findAllGenres() {
        return genreRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<GenreDTO> findGenreById(Long id) {
        return genreRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public GenreDTO saveGenre(GenreEntity genre) {
        GenreEntity savedGenre = genreRepository.save(genre);
        return convertToDTO(savedGenre);
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    private GenreDTO convertToDTO(GenreEntity genre) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genre.getId());
        genreDTO.setName(genre.getName());
        return genreDTO;
    }
    @Override
    public Optional<GenreEntity> findByName(String name) {
        return genreRepository.findByName(name);
    }

    @Override
    public GenreDTO saveGenre(GenreDTO genreDTO) {
        GenreEntity genreEntity = convertToEntity(genreDTO);
        GenreEntity savedGenre = genreRepository.save(genreEntity);
        return convertToDTO(savedGenre);
    
}

    private GenreEntity convertToEntity(GenreDTO genreDTO) {
        GenreEntity genre = new GenreEntity();
        genre.setName(genreDTO.getName());
        return genre;
    }
}
