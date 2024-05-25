package com.foody.restaurantservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "comment-service")
public interface CommentServiceFeignClient {
    //TODO get comments for related restaurant gibi bi şey, restoranın altındaki foodlar için de bir connection atılabilir
}