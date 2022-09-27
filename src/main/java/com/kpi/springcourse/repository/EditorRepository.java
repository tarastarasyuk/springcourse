package com.kpi.springcourse.repository;

import com.kpi.springcourse.model.Editor;
import com.kpi.springcourse.model.Student;

import java.util.Optional;

public interface EditorRepository extends CrudRepository<Editor, Long> {
    boolean checkIfEmailAvailable(String email);

    Optional<Editor> findByEmail(String email);
}
