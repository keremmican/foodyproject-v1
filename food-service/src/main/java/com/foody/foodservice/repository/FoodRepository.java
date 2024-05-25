package com.foody.foodservice.repository;

import com.foody.commonlib.base.BaseRepository;
import com.foody.foodservice.mapper.FoodRowMapper;
import com.foody.foodservice.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FoodRepository implements BaseRepository<Food, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Food save(Food food) {
        String query = "INSERT INTO food (id, name, description, rating, image_url, price) VALUES (?, ?, ?, ?, ?, ?)";
        Long id = jdbcTemplate.queryForObject("SELECT nextval('food_seq')", Long.class);
        jdbcTemplate.update(query, id, food.getName(), food.getDescription(), food.getRating(), food.getImageUrl(), food.getPrice());
        return findById(id).orElse(null);
    }

    @Override
    public Food update(Food food) {
        String query = "UPDATE food SET name = ?, description = ?, rating = ?, image_url = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(query, food.getName(), food.getDescription(), food.getRating(), food.getImageUrl(), food.getPrice(), food.getId());
        return findById(food.getId()).orElse(null);
    }

    @Override
    public void delete(Food object) {
        String query = "DELETE FROM food WHERE id = ?";
        jdbcTemplate.update(query, object.getId());
    }

    @Override
    public Optional<Food> findById(Long id) {
        String query = "SELECT * FROM food WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, new Object[]{id}, new FoodRowMapper()));
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE FROM food WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Page<Food> getAllPageable(Pageable pageable) {
        String query = "SELECT * FROM food";
        String countQuery = "SELECT count(*) FROM food";

        if (pageable.getSort().isSorted()) {
            query += " ORDER BY " + pageable.getSort().toString().replace(":", "");
        }

        query += " LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

        List<Food> foodList = jdbcTemplate.query(query, new FoodRowMapper());
        Long totalElements = jdbcTemplate.queryForObject(countQuery, Long.class);

        return new PageImpl<>(foodList, pageable, totalElements);
    }
}
