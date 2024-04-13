package com.foody.restaurantservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "food-service")
public interface FoodServiceClient {
}
