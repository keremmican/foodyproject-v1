package com.foody.restaurantservice.repository;

import com.foody.commonlib.base.BaseRepository;
import com.foody.restaurantservice.mapper.RestaurantRowMapper;
import com.foody.restaurantservice.model.Restaurant;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RestaurantRepository implements BaseRepository<Restaurant, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Restaurant save(Restaurant object) {
        String query = "INSERT INTO restaurant (id, name, address_line, phone, email) VALUES (?, ?, ?, ?, ?)";
        Long id = jdbcTemplate.queryForObject("SELECT nextval('restaurant_seq')", Long.class);
        jdbcTemplate.update(query, id, object.getName(), object.getAddressLine(), object.getPhone(), object.getEmail());
        return findById(id).orElse(null);
    }

    @Override
    public Restaurant update(Restaurant object) {
        String query = "UPDATE restaurant SET name = ?, address_line = ?, phone = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(query, object.getName(), object.getAddressLine(), object.getPhone(), object.getEmail(), object.getId());
        return findById(object.getId()).orElse(null);
    }

    @Override
    public void delete(Restaurant object) {
        String query = "DELETE FROM restaurant WHERE id = ?";
        jdbcTemplate.update(query, object.getId());
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        String query = "SELECT * FROM restaurant WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, new Object[]{id}, new RestaurantRowMapper()));
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE FROM restaurant WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Page<Restaurant> getAllPageable(Pageable pageable) {
        String query = "SELECT * FROM restaurant";
        String countQuery = "SELECT count(*) FROM restaurant";

        if (pageable.getSort().isSorted()) {
            query += " ORDER BY " + pageable.getSort().toString().replace(":", "");
        }

        query += " LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

        List<Restaurant> restaurantList = jdbcTemplate.query(query, new RestaurantRowMapper());
        Long totalElements = jdbcTemplate.queryForObject(countQuery, Long.class);

        return new PageImpl<>(restaurantList, pageable, totalElements);
    }
}
