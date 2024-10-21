package com.revcinema.model;

import com.revcinema.dto.MovieDTO;
import com.revcinema.dto.UserDTO;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favorites")
@Data
public class FavoritesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersEntity user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieEntity movie;
}
