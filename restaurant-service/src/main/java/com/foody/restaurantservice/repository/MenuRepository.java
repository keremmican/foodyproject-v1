package com.foody.restaurantservice.repository;

import com.foody.commonlib.base.BaseRepository;
import com.foody.restaurantservice.mapper.MenuRowMapper;
import com.foody.restaurantservice.model.Menu;
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
public class MenuRepository implements BaseRepository<Menu, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public Menu save(Menu object) {
        String query = "INSERT INTO menu (id, name, description) VALUES (?, ?, ?)";
        Long id = jdbcTemplate.queryForObject("SELECT nextval('menu_seq')", Long.class);
        jdbcTemplate.update(query, id, object.getName(), object.getDescription());
        return findById(id).orElse(null);
    }

    @Override
    public Menu update(Menu object) {
        String query = "UPDATE menu SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(query, object.getName(), object.getDescription());
        return findById(object.getId()).orElse(null);
    }

    @Override
    public void delete(Menu object) {
        String query = "DELETE FROM menu WHERE id = ?";
        jdbcTemplate.update(query, object.getId());
    }

    @Override
    public Optional<Menu> findById(Long id) {
        String query = "SELECT * FROM menu WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, new Object[]{id}, new MenuRowMapper()));
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE FROM menu WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Page<Menu> getAllPageable(Pageable pageable) {
        String query = "SELECT * FROM menu";
        String countQuery = "SELECT count(*) FROM menu";

        if (pageable.getSort().isSorted()) {
            query += " ORDER BY " + pageable.getSort().toString().replace(":", "");
        }

        query += " LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

        List<Menu> restaurantList = jdbcTemplate.query(query, new MenuRowMapper());
        Long totalElements = jdbcTemplate.queryForObject(countQuery, Long.class);

        return new PageImpl<>(restaurantList, pageable, totalElements);
    }
}
