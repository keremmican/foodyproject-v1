package com.foody.commentservice.repository;

import com.foody.commonlib.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CommentRepository implements BaseRepository {
    @Override
    public Object save(Object object) {
        return null;
    }

    @Override
    public Object update(Object object) {
        return null;
    }

    @Override
    public void delete(Object object) {

    }

    @Override
    public Optional findById(Object id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Object id) {

    }

    @Override
    public Page getAllPageable(Pageable pageable) {
        return null;
    }
}
