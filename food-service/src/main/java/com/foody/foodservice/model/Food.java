package com.foody.foodservice.model;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food")
public class Food {
    private String name;
    private String description;
    private Double rating;
    private String imageUrl;
    private BigDecimal price;
}
