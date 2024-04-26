package com.foody.restaurantservice.dto.request;

import lombok.Data;

@Data
public class CreateRestaurantRequestDto {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String addressLine;
}
