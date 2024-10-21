package com.revcinema.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revcinema.model.MovieEntity;
@Repository

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
	public Optional<MovieEntity> findMovieEntityById(Long id);

}
