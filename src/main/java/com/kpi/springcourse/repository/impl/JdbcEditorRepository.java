package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Editor;
import com.kpi.springcourse.repository.EditorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcEditorRepository implements EditorRepository {
    @Override
    public Editor create(Editor entity) {
        return null;
    }

    @Override
    public Optional<Editor> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Editor> findAll() {
        return null;
    }

    @Override
    public Editor update(Editor source, Editor target) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }

    @Override
    public Optional<Editor> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public boolean checkIfEmailAvailable(String email) {
        return false;
    }
}
