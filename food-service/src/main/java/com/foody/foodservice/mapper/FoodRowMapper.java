package com.foody.foodservice.mapper;

import com.foody.foodservice.model.Food;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class FoodRowMapper implements RowMapper<Food> {

    @Override
    public Food mapRow(ResultSet rs, int rowNum) throws SQLException {
        Food food = new Food();
        food.setId(rs.getLong("id"));
        food.setName(rs.getString("name"));
        food.setDescription(rs.getString("description"));
        food.setRating(rs.getDouble("rating"));
        food.setPrice(rs.getBigDecimal("price"));
        food.setImageUrl(rs.getString("image_url"));
        return food;
    }
}
