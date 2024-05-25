package com.foody.restaurantservice.mapper;

import com.foody.restaurantservice.model.MenuCategory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MenuCategoryRowMapper implements RowMapper<MenuCategory> {
    @Override
    public MenuCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        MenuCategory menuCategory = new MenuCategory();

        menuCategory.setId(rs.getLong("id"));
        menuCategory.setName(rs.getString("name"));
        menuCategory.setDescription(rs.getString("description"));

        return null;
    }
}
