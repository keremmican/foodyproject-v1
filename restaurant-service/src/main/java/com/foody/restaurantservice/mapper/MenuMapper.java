package com.foody.restaurantservice.mapper;

import com.foody.restaurantservice.dto.MenuDto;
import com.foody.restaurantservice.model.Menu;

public class MenuMapper {
    public static Menu toMenu(MenuDto menuDto) {
        Menu menu = new Menu();

        menu.setName(menuDto.getName());
        menu.setDescription(menuDto.getDescription());
        //menu.setMenuCategories();

        return menu;
    }
}
