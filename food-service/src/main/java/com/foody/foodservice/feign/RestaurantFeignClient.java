package com.foody.foodservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "restaurant-service")
public interface RestaurantFeignClient {

    //TODO get related menu or restaurant gibi bir istek
}
