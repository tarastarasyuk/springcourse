package com.kpi.springcourse.repository;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.model.Student;

public interface StudentRepository extends UserRepository<Student, Long> {
    void likeUnlikeOpportunity(Student student, Opportunity opportunity);
}
