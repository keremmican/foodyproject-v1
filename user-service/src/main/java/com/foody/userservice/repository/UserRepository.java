package com.foody.userservice.repository;

import com.foody.commonlib.base.BaseRepository;
import com.foody.userservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository implements BaseRepository<User, Long> {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public User save(User object) {
        return null;
    }

    @Override
    public User update(User object) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return null;
    }
}
