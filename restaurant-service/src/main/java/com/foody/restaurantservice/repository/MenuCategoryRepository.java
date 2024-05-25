package com.foody.restaurantservice.repository;

import com.foody.commonlib.base.BaseRepository;
import com.foody.restaurantservice.mapper.MenuCategoryRowMapper;
import com.foody.restaurantservice.model.MenuCategory;
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
public class MenuCategoryRepository implements BaseRepository<MenuCategory, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public MenuCategory save(MenuCategory object) {
        String query = "INSERT INTO menu_category (id, name, description) VALUES (?, ?, ?)";
        Long id = jdbcTemplate.queryForObject("SELECT nextval('menu_category_seq')", Long.class);
        jdbcTemplate.update(query, id, object.getName(), object.getDescription());
        return findById(id).orElse(null);
    }

    @Override
    public MenuCategory update(MenuCategory object) {
        String query = "UPDATE menu_category SET name = ?, description = ? WHERE id = ?";
        jdbcTemplate.update(query, object.getName(), object.getDescription());
        return findById(object.getId()).orElse(null);
    }

    @Override
    public void delete(MenuCategory object) {
        String query = "DELETE FROM menu_category WHERE id = ?";
        jdbcTemplate.update(query, object.getId());
    }

    @Override
    public Optional<MenuCategory> findById(Long id) {
        String query = "SELECT * FROM menu_category WHERE id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(query, new Object[]{id}, new MenuCategoryRowMapper()));
    }

    @Override
    public void deleteById(Long id) {
        String query = "DELETE FROM menu_category WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Page<MenuCategory> getAllPageable(Pageable pageable) {
        String query = "SELECT * FROM menu_category";
        String countQuery = "SELECT count(*) FROM menu_category";

        if (pageable.getSort().isSorted()) {
            query += " ORDER BY " + pageable.getSort().toString().replace(":", "");
        }

        query += " LIMIT " + pageable.getPageSize() + " OFFSET " + pageable.getOffset();

        List<MenuCategory> restaurantList = jdbcTemplate.query(query, new MenuCategoryRowMapper());
        Long totalElements = jdbcTemplate.queryForObject(countQuery, Long.class);

        return new PageImpl<>(restaurantList, pageable, totalElements);
    }
}
