package com.revcinema.dto;

import lombok.Data;

@Data
public class MovieDTO {
    private Long id;
    private String title;
    private String genreName;
    private String description;
    private String cast;
    private String production;
}
