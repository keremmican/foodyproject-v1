package com.foody.foodservice.service;

import com.foody.foodservice.dto.FoodDto;
import com.foody.foodservice.dto.request.CreateFoodRequestDto;
import com.foody.foodservice.dto.request.UpdateFoodRequestDto;
import com.foody.foodservice.exception.ServiceException;
import com.foody.foodservice.mapper.FoodMapper;
import com.foody.foodservice.model.Food;
import com.foody.foodservice.repository.FoodRepository;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    @Transactional
    public FoodDto createFood(CreateFoodRequestDto requestDto) {
        Food foodEntity = FoodMapper.toFood(requestDto);

        return FoodMapper.toFoodDto(foodRepository.save(foodEntity));
    }

    @Transactional
    public FoodDto updateFood(UpdateFoodRequestDto requestDto) {
        Food foodEntity = findFoodById(requestDto.getId());
        FoodMapper.toFood(requestDto, foodEntity);

        return FoodMapper.toFoodDto(foodRepository.update(foodEntity));
    }

    public FoodDto getFoodById(Long id) {
        return FoodMapper.toFoodDto(findFoodById(id));
    }

    @Transactional
    public void deleteFoodById(Long id) {
        foodRepository.deleteById(id);
    }

    private Food findFoodById(Long id) {
        return foodRepository.findById(id).orElseThrow(NotFoundException::new);
    }
}
