package com.foody.userservice.controller;

import com.foody.commonlib.constants.FoodyConstants;
import com.foody.userservice.dto.UserDto;
import com.foody.userservice.dto.request.UserRequest;
import com.foody.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(FoodyConstants.PREFIX + "user")
public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createFood(@RequestBody UserRequest requestDto) {
        //return ResponseEntity.status(HttpStatus.CREATED).body(foodService.createFood(requestDto));
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateFood(@RequestBody UserRequest requestDto) {
        //return ResponseEntity.status(HttpStatus.OK).body(foodService.updateFood(requestDto));
        return null;
    }

    @GetMapping("/{foodId}")
    public ResponseEntity<UserDto> getFood(@PathVariable Long foodId) {
        //return ResponseEntity.status(HttpStatus.FOUND).body(foodService.getFoodById(foodId));
        return null;
    }

    @DeleteMapping("/{foodId}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long foodId) {
        //foodService.deleteFoodById(foodId);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<UserDto>> getAllFoodsPageable(@RequestParam(name = "index") int index,
                                                             @RequestParam(name = "size") int size) {
        //return ResponseEntity.status(HttpStatus.FOUND).body(foodService.getAllFoodsPageable(index, size));
        return null;
    }
}
