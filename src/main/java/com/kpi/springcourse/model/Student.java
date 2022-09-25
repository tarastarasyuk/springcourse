package com.kpi.springcourse.model;

import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString(callSuper = true)
public class Student extends User {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phone;
    private Set<Skill> skills;
    private Set<Opportunity> likedOpportunities = new HashSet<>();

    public Student(Long id, String email, String firstName, String lastName, Integer age, String phone, Set<Skill> skills) {
        super(id, email, Role.ROLE_STUDENT);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.skills = skills;
    }
}
