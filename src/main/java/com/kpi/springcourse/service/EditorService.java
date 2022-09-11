package com.kpi.springcourse.service;

import com.kpi.springcourse.model.Editor;
import com.kpi.springcourse.repository.EditorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EditorService {
    private EditorRepository editorRepository;

    public Editor create(Editor entity) {
        return editorRepository.create(entity);
    }

    public Editor findById(Long id) {
        return editorRepository.findById(id);
    }

    public List<Editor> findAll() {
        return editorRepository.findAll();
    }

    public Editor update(Editor source, Editor target) {
        return editorRepository.update(source, target);
    }

    public Editor delete(Long id) {
        return editorRepository.delete(id);
    }

}
