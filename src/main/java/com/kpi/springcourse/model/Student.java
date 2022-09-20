package com.kpi.springcourse.model;

import lombok.Data;

import java.util.Set;

@Data
public class Student extends User {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private Set<Skill> skills;

    public Student(Long id, String email, String password, String firstName, String lastName, Integer age, String phone, Set<Skill> skills) {
        super(id, email, password, Role.ROLE_STUDENT);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.skills = skills;
    }
}
