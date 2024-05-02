package com.foody.foodservice.controller;

import com.foody.commonlib.constants.FoodyConstants;
import com.foody.foodservice.dto.FoodDto;
import com.foody.foodservice.dto.request.CreateFoodRequestDto;
import com.foody.foodservice.dto.request.UpdateFoodRequestDto;
import com.foody.foodservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(FoodyConstants.PREFIX + "food")
public class FoodController {
    private final FoodService foodService;

    @PostMapping("/create")
    public ResponseEntity<FoodDto> createFood(@RequestBody CreateFoodRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(foodService.createFood(requestDto));
    }

    @PutMapping("/update")
    public ResponseEntity<FoodDto> updateFood(@RequestBody UpdateFoodRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(foodService.updateFood(requestDto));
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<FoodDto> getFood(@PathVariable Long foodId) {
        return ResponseEntity.status(HttpStatus.FOUND).body(foodService.getFoodById(foodId));
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long foodId) {
        foodService.deleteFoodById(foodId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<FoodDto>> getAllFoodsPageable(@RequestParam(name = "index") int index,
                                                             @RequestParam(name = "size") int size) {
        return ResponseEntity.status(HttpStatus.FOUND).body(foodService.getAllFoodsPageable(index, size));
    }
}
