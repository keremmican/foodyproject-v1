package com.foody.restaurantservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class UpdateMenuRequestDto {
    private String name;
    private String description;

    List<MenuCategory> categories;

    @Data
    private static class MenuCategory {
        private String name;
        private String description;
        private List<Long> foodId;
    }
}
