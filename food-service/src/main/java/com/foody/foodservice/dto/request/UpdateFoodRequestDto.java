package com.foody.foodservice.dto.request;

import jakarta.validation.constraints.Min;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateFoodRequestDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    @Min(0)
    private BigDecimal price;
}
