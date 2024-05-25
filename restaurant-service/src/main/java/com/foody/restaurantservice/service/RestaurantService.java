package com.foody.restaurantservice.service;

import com.foody.restaurantservice.dto.RestaurantDto;
import com.foody.restaurantservice.dto.request.CreateRestaurantRequestDto;
import com.foody.restaurantservice.dto.request.UpdateRestaurantRequestDto;
import com.foody.restaurantservice.mapper.RestaurantMapper;
import com.foody.restaurantservice.model.Restaurant;
import com.foody.restaurantservice.repository.RestaurantRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantDto createRestaurant(CreateRestaurantRequestDto requestDto) {
        Restaurant restaurant = RestaurantMapper.toRestaurant(requestDto);

        return RestaurantMapper.toRestaurantDto(restaurantRepository.save(restaurant));
    }

    public RestaurantDto updateRestaurant(UpdateRestaurantRequestDto requestDto, Long id) {
        Restaurant restaurant = findRestaurantById(id);
        RestaurantMapper.toRestaurant(requestDto, restaurant);

        return RestaurantMapper.toRestaurantDto(restaurantRepository.update(restaurant));
    }

    public RestaurantDto getRestaurantById(Long id) {
        Restaurant restaurant = findRestaurantById(id);
        return RestaurantMapper.toRestaurantDto(restaurant);
    }

    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }

    private Restaurant findRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Page<RestaurantDto> getAllRestaurantsPageable(int index, int size) {
        Page<Restaurant> foodEntities = restaurantRepository.getAllPageable(PageRequest.of(index, size));
        return foodEntities.map(RestaurantMapper::toRestaurantDto);
    }
}
