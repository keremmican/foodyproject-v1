package com.foody.restaurantservice.mapper;

import com.foody.restaurantservice.model.Menu;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MenuRowMapper implements RowMapper<Menu> {
    @Override
    public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
        Menu menu = new Menu();

        menu.setId(rs.getLong("id"));
        menu.setName(rs.getString("name"));
        menu.setDescription(rs.getString("description"));

        return menu;
    }
}
