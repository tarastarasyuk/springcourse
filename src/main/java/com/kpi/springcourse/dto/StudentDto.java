package com.kpi.springcourse.dto;

import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class StudentDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer age;
    private String[] skills;

    public Student toStudent(Set<Skill> skillSet) {
        return new Student(email, firstName, lastName, age, phone, skillSet);
    }
}
