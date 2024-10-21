package com.revcinema.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.revcinema.controller.FavoritesControllerInterface;
import com.revcinema.dto.FavoritesDTO;
import com.revcinema.service.FavoritesService;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/favorites")
public class FavoritesControllerImpl implements FavoritesControllerInterface {
    @Autowired
    private FavoritesService favoritesService;

    @Override
    @GetMapping
    public List<FavoritesDTO> getAllFavorites() {
        return favoritesService.findAllFavorites();
    }

    @Override
    @GetMapping("/{id}")
    public Optional<FavoritesDTO> getFavoriteById(@PathVariable Long id) {
        return favoritesService.findFavoriteById(id);
    }

    @Override
    @PostMapping
    public ResponseEntity<FavoritesDTO> createFavorite(@Valid @RequestBody FavoritesDTO favorite) {
        FavoritesDTO savedFavorite = favoritesService.saveFavorite(favorite);
        return ResponseEntity.ok(savedFavorite);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable Long id) {
        favoritesService.deleteFavorite(id);
    }
}
