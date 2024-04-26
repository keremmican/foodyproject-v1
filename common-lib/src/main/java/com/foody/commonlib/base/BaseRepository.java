package com.foody.commonlib.base;

import java.util.Optional;

public interface BaseRepository<T, U> {
    T save(T object);
    T update(T object);
    void delete(T object);
    Optional<T> findById(U id);
    void deleteById(U id);
}
