package com.revcinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revcinema.repository.FavoritesRepository;
import com.revcinema.dto.FavoritesDTO;
import com.revcinema.model.FavoritesEntity;
import com.revcinema.service.FavoritesService;
import com.revcinema.service.MovieService;
import com.revcinema.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesRepository favoritesRepository;
    @Autowired
    private UserService userService; // Ensure UserService is autowired

    @Autowired
    private MovieService movieService; // Ensure MovieService is autowired


    @Override
    public List<FavoritesDTO> findAllFavorites() {
        return favoritesRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<FavoritesDTO> findFavoriteById(Long id) {
        return favoritesRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public FavoritesDTO saveFavorite(FavoritesEntity favorite) {
        FavoritesEntity savedFavorite = favoritesRepository.save(favorite);
        return convertToDTO(savedFavorite);
    }

    @Override
    public void deleteFavorite(Long id) {
        favoritesRepository.deleteById(id);
    }

    private FavoritesDTO convertToDTO(FavoritesEntity favorite) {
        FavoritesDTO favoritesDTO = new FavoritesDTO();
        favoritesDTO.setId(favorite.getId());
        favoritesDTO.setUserId(favorite.getUser().getId());
        favoritesDTO.setMovieId(favorite.getMovie().getId());
        return favoritesDTO;
    }

    @Override
    public FavoritesDTO saveFavorite(FavoritesDTO favoritesDTO) {
        FavoritesEntity favoriteEntity = convertToEntity(favoritesDTO);
        FavoritesEntity savedFavorite = favoritesRepository.save(favoriteEntity);
        return convertToDTO(savedFavorite);
    }

    private FavoritesEntity convertToEntity(FavoritesDTO favoritesDTO) {
        FavoritesEntity favorite = new FavoritesEntity();
        favorite.setUser(userService.findUserEntityById(favoritesDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found")));
        favorite.setMovie(movieService.findMovieEntityById(favoritesDTO.getMovieId()).orElseThrow(() -> new RuntimeException("Movie not found")));
        return favorite;
    }
}
