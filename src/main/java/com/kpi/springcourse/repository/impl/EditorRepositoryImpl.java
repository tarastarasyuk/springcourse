package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Editor;
import com.kpi.springcourse.repository.EditorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EditorRepositoryImpl implements EditorRepository {
    private final Map<Long, Editor> editorMap;

    public EditorRepositoryImpl() {
        editorMap = new HashMap<>(Map.of(
                1L, new Editor(1L, "test@tat.ss"),
                2L, new Editor(2L, "admin@tat.ss"),
                3L, new Editor(3L, "tettttt@tat.ss"),
                4L, new Editor(4L, "red@tat.ss")
        ));
    }

    @Override
    public Editor create(Editor entity) {
        entity.setId(editorMap.size() + 1L);
        editorMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Editor findById(Long aLong) {
        return editorMap.get(aLong);
    }

    @Override
    public List<Editor> findAll() {
        return new ArrayList<>(editorMap.values());
    }

    @Override
    public Editor update(Editor source, Editor target) {
        return editorMap.put(target.getId(), source);
    }

    @Override
    public Editor delete(Long aLong) {
        return editorMap.remove(aLong);
    }
}
