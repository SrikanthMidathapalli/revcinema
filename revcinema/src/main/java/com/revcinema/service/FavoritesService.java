package com.revcinema.service;

import com.revcinema.dto.FavoritesDTO;
import com.revcinema.model.FavoritesEntity;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface FavoritesService {
    List<FavoritesDTO> findAllFavorites();
    Optional<FavoritesDTO> findFavoriteById(Long id);
    FavoritesDTO saveFavorite(FavoritesDTO favorite);
    void deleteFavorite(Long id);
	FavoritesDTO saveFavorite(FavoritesEntity favorite);
}
