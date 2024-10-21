package com.revcinema.dto;

import lombok.Data;

@Data
public class FavoritesDTO {
    private Long id;
    private Long userId;
    private Long movieId;
}
