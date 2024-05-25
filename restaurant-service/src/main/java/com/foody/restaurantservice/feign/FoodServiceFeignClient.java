package com.foody.restaurantservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "food-service")
public interface FoodServiceFeignClient {
    //TODO get food list response by id gibi bi şey
}
