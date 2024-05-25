package com.foody.restaurantservice.dto.request;

import lombok.Data;

@Data
public class UpdateRestaurantRequestDto {
    private String name;
    private String phone;
    private String email;
    private String addressLine;
}
