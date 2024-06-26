package com.foody.foodservice.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Double rating;
}
