package com.foody.restaurantservice.mapper;

import com.foody.restaurantservice.model.Restaurant;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RestaurantRowMapper implements RowMapper<Restaurant> {

    @Override
    public Restaurant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(rs.getLong("id"));
        restaurant.setName(rs.getString("name"));
        restaurant.setAddressLine(rs.getString("address_line"));
        restaurant.setPhone(rs.getString("phone"));
        restaurant.setEmail(rs.getString("email"));
        restaurant.setAvgRating(rs.getDouble("avg_rating"));
        restaurant.setMenuId(rs.getLong("menu_id"));

        return restaurant;
    }
}
