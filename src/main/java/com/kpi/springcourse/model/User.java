package com.kpi.springcourse.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(of = {"id", "email"})
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {
    private Long id;
    private String email;
    private Role role;

    public User(String email, Role role) {
        this.email = email;
        this.role = role;
    }
}
