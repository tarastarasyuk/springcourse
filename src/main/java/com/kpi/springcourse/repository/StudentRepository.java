package com.kpi.springcourse.repository;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.model.Student;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    void likeUnlikeOpportunity(Student student, Opportunity opportunity);
    Optional<Student> findByEmail(String email);
    boolean checkIfEmailAvailable(String email);
}
