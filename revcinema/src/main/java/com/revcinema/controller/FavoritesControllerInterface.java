package com.revcinema.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.revcinema.dto.FavoritesDTO;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface FavoritesControllerInterface {
    List<FavoritesDTO> getAllFavorites();

    Optional<FavoritesDTO> getFavoriteById(@PathVariable Long id);

    ResponseEntity<FavoritesDTO> createFavorite(@Valid @RequestBody FavoritesDTO favorite);

    void deleteFavorite(@PathVariable Long id);
}
