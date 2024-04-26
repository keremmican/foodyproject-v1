package com.foody.restaurantservice.service;

import com.foody.restaurantservice.dto.RestaurantDto;
import com.foody.restaurantservice.dto.request.CreateRestaurantRequestDto;
import com.foody.restaurantservice.dto.request.UpdateRestaurantRequestDto;
import com.foody.restaurantservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantDto createRestaurant(CreateRestaurantRequestDto requestDto) {
        return null;
    }

    public RestaurantDto updateRestaurant(UpdateRestaurantRequestDto requestDto) {
        return null;
    }

    public RestaurantDto getRestaurantById(Long id) {
        return null;
    }

    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }
}
