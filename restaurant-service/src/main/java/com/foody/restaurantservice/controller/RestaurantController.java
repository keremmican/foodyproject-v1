package com.foody.restaurantservice.controller;

import com.foody.commonlib.constants.FoodyConstants;
import com.foody.restaurantservice.dto.RestaurantDto;
import com.foody.restaurantservice.dto.request.CreateRestaurantRequestDto;
import com.foody.restaurantservice.dto.request.UpdateRestaurantRequestDto;
import com.foody.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(FoodyConstants.PREFIX + "restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<RestaurantDto> createRestaurant(CreateRestaurantRequestDto requestDto) {
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<RestaurantDto> updateRestaurant(UpdateRestaurantRequestDto requestDto) {
        return null;
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Long restaurantId) {
        return null;
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long restaurantId) {
        return null;
    }
}
