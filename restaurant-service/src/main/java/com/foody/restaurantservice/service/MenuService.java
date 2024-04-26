package com.foody.restaurantservice.service;

import com.foody.restaurantservice.dto.MenuDto;
import com.foody.restaurantservice.dto.request.CreateMenuRequestDto;
import com.foody.restaurantservice.dto.request.UpdateMenuRequestDto;
import com.foody.restaurantservice.model.Menu;
import com.foody.restaurantservice.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuDto createMenu(CreateMenuRequestDto requestDto) {
        return null;
    }

    public MenuDto updateMenu(UpdateMenuRequestDto requestDto) {
        return null;
    }

    public MenuDto getMenuById(Long id) {
        return null;
    }

    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }
}
