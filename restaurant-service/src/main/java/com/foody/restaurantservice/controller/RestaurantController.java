package com.foody.restaurantservice.controller;

import com.foody.commonlib.constants.FoodyConstants;
import com.foody.restaurantservice.dto.RestaurantDto;
import com.foody.restaurantservice.dto.request.CreateRestaurantRequestDto;
import com.foody.restaurantservice.dto.request.UpdateRestaurantRequestDto;
import com.foody.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(FoodyConstants.PREFIX + "restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<RestaurantDto> createRestaurant(@RequestBody CreateRestaurantRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.createRestaurant(requestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<RestaurantDto> updateRestaurant(@RequestBody UpdateRestaurantRequestDto requestDto, @RequestParam("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.updateRestaurant(requestDto, id));
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<RestaurantDto> getRestaurant(@PathVariable Long restaurantId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(restaurantService.getRestaurantById(restaurantId));
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long restaurantId) {
        restaurantService.deleteRestaurantById(restaurantId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<RestaurantDto>> getAllFoodsPageable(@RequestParam(name = "index") int index,
                                                             @RequestParam(name = "size") int size) {
        return ResponseEntity.status(HttpStatus.FOUND).body(restaurantService.getAllRestaurantsPageable(index, size));
    }
}
