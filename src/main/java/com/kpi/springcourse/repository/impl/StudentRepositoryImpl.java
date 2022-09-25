package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private final Map<Long, Student> studentMap;

    public StudentRepositoryImpl() {
        studentMap = new HashMap<>(Map.of(
                1L, new Student(1L, "test1@tat.ss", "qwerty", "Taras", "Tarasiuk", 34, "094345342", Set.of(new Skill("piano"))),
                2L, new Student(2L, "test2@tat.ss", "qwerty", "Roman", "Bondarenko", 67, "085345233", Set.of(new Skill("chilling"))),
                3L, new Student(3L, "test3@tat.ss", "qwerty", "Nadia", "Prokhorchuk", 12, "034523452", Set.of(new Skill("painting"))),
                4L, new Student(4L, "test4@tat.ss", "qwerty", "Bob", "Bobuk", 19, "043454452", Set.of(new Skill("java"))),
                5L, new Student(5L, "test5@tat.ss", "qwerty", "Sam", "Samuk", 16, "03454523452", Set.of(new Skill("c++"))),
                6L, new Student(6L, "test6@tat.ss", "qwerty", "Bill", "Billuk", 62, "034554423452", Set.of(new Skill("scala"))),
                7L, new Student(7L, "test7@tat.ss", "qwerty", "Kate", "Katuk", 21, "03454323452", Set.of(new Skill("python"))))
        );
    }

    @Override
    public Student create(Student entity) {
        entity.setId(studentMap.size() + 1L);
        studentMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Student findById(Long aLong) {
        return studentMap.get(aLong);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student update(Student source, Student target) {
        return studentMap.put(target.getId(), source);
    }

    @Override
    public Student delete(Long aLong) {
        return studentMap.remove(aLong);
    }
}
