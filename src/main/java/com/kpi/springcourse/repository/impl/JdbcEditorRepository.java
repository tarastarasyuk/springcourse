package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Editor;
import com.kpi.springcourse.repository.EditorRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class JdbcEditorRepository implements EditorRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Editor create(Editor entity) {
        return null;
    }

    @Override
    public Editor findById(Long aLong) {
        return null;
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
    public Editor delete(Long aLong) {
        return null;
    }

    @Override
    public boolean checkIfEmailAvailable(String email) {
        return false;
    }

    @Override
    public Optional<Editor> findByEmail(String email) {
        return Optional.empty();
    }
}
