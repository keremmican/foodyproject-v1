package com.foody.foodservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "comment-service")
public interface CommentFeignClient {
    //TODO get comments for related food gibi bi şey
}
