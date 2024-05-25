package com.foody.restaurantservice.mapper;

import com.foody.restaurantservice.dto.RestaurantDto;
import com.foody.restaurantservice.dto.request.CreateRestaurantRequestDto;
import com.foody.restaurantservice.dto.request.UpdateRestaurantRequestDto;
import com.foody.restaurantservice.model.Restaurant;

public class RestaurantMapper {
    public static Restaurant toRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantDto.getId());
        restaurant.setName(restaurantDto.getName());
        restaurant.setAddressLine(restaurantDto.getAddressLine());
        restaurant.setPhone(restaurantDto.getPhone());
        restaurant.setEmail(restaurantDto.getEmail());
        restaurant.setAvgRating(restaurantDto.getAvgRating());
        restaurant.setMenuId(restaurantDto.getMenuId());

        return restaurant;
    }

    public static Restaurant toRestaurant(CreateRestaurantRequestDto requestDto) {
        Restaurant restaurant = new Restaurant();

        restaurant.setName(requestDto.getName());
        restaurant.setAddressLine(requestDto.getAddressLine());
        restaurant.setPhone(requestDto.getPhone());
        restaurant.setEmail(requestDto.getEmail());

        return restaurant;
    }

    public static Restaurant toRestaurant(UpdateRestaurantRequestDto requestDto, Restaurant restaurant) {

        restaurant.setName(requestDto.getName());
        restaurant.setAddressLine(requestDto.getAddressLine());
        restaurant.setPhone(requestDto.getPhone());
        restaurant.setEmail(requestDto.getEmail());

        return restaurant;
    }

    public static RestaurantDto toRestaurantDto(Restaurant restaurant) {
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setAddressLine(restaurant.getAddressLine());
        restaurantDto.setPhone(restaurant.getPhone());
        restaurantDto.setEmail(restaurant.getEmail());
        restaurantDto.setAvgRating(restaurant.getAvgRating());
        restaurantDto.setMenuId(restaurant.getMenuId());

        return restaurantDto;
    }
}
