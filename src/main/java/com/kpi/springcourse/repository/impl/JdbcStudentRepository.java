package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcStudentRepository implements StudentRepository {
    @Override
    public Student create(Student entity) {
        return null;
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return Optional.empty();
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
    public void delete(Long aLong) {

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
