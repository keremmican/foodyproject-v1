package com.foody.restaurantservice.controller;

import com.foody.commonlib.constants.FoodyConstants;
import com.foody.restaurantservice.dto.MenuDto;
import com.foody.restaurantservice.dto.request.CreateRestaurantRequestDto;
import com.foody.restaurantservice.dto.request.UpdateRestaurantRequestDto;
import com.foody.restaurantservice.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(FoodyConstants.PREFIX + "menu")
public class MenuController {
    private final MenuService menuService;

    @PostMapping("/create")
    public ResponseEntity<MenuDto> createMenu(CreateRestaurantRequestDto requestDto) {
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<MenuDto> updateMenu(UpdateRestaurantRequestDto requestDto) {
        return null;
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<MenuDto> getMenu(@PathVariable Long menuId) {
        return null;
    }

    @DeleteMapping("/{menuId}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long menuId) {
        return null;
    }
}
