package com.foody.foodservice.mapper;

import com.foody.foodservice.dto.FoodDto;
import com.foody.foodservice.dto.request.CreateFoodRequestDto;
import com.foody.foodservice.dto.request.UpdateFoodRequestDto;
import com.foody.foodservice.model.Food;

public class FoodMapper {

    public static Food toFood(FoodDto foodDto) {
        Food food = new Food();
        food.setId(foodDto.getId());
        food.setName(foodDto.getName());
        food.setPrice(foodDto.getPrice());
        food.setDescription(foodDto.getDescription());
        food.setImageUrl(foodDto.getImageUrl());
        food.setRating(foodDto.getRating());
        return food;
    }

    public static Food toFood(CreateFoodRequestDto requestDto) {
        Food food = new Food();

        food.setName(requestDto.getName());
        food.setPrice(requestDto.getPrice());
        food.setDescription(requestDto.getDescription());
        food.setImageUrl(requestDto.getImageUrl());

        return food;
    }

    public static Food toFood(UpdateFoodRequestDto requestDto, Food food) {
        food.setName(requestDto.getName());
        food.setPrice(requestDto.getPrice());
        food.setDescription(requestDto.getDescription());
        food.setImageUrl(requestDto.getImageUrl());
        return food;
    }

    public static FoodDto toFoodDto(Food food) {
        FoodDto foodDto = new FoodDto();
        foodDto.setId(food.getId());
        foodDto.setName(food.getName());
        foodDto.setPrice(food.getPrice());
        foodDto.setDescription(food.getDescription());
        foodDto.setImageUrl(food.getImageUrl());
        foodDto.setRating(food.getRating());

        return foodDto;
    }
}
