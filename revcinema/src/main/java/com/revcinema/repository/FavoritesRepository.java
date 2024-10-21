package com.revcinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revcinema.model.FavoritesEntity;
@Repository
public interface FavoritesRepository extends JpaRepository<FavoritesEntity, Long> {
}
