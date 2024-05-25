package com.foody.restaurantservice.dto;

import lombok.Data;

@Data
public class RestaurantDto {
    private Long id;
    private String name;
    private String addressLine;
    private String phone;
    private String email;
    private Double avgRating;
    private Long menuId;
}
