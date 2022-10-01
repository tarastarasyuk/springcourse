package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class JdbcStudentRepository implements StudentRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Student create(Student entity) {
        return null;
    }

    @Override
    public Student findById(Long aLong) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student update(Student source, Student target) {
        return null;
    }

    @Override
    public Student delete(Long aLong) {
        return null;
    }

    @Override
    public void likeUnlikeOpportunity(Student student, Opportunity opportunity) {

    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public boolean checkIfEmailAvailable(String email) {
        return false;
    }
}
