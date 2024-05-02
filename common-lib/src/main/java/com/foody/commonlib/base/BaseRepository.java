package com.foody.commonlib.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface BaseRepository<T, U> {
    T save(T object);
    T update(T object);
    void delete(T object);
    Optional<T> findById(U id);
    void deleteById(U id);
    Page<T> getAllPageable(Pageable pageable);
}
