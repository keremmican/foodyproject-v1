package com.foody.restaurantservice.dto.request;

import lombok.Data;

@Data
public class UpdateRestaurantRequestDto {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String addressLine;
}
