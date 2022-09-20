package com.kpi.springcourse.model;

public class Editor extends User {
    public Editor(Long id, String email, String password) {
        super(id, email, password, Role.ROLE_EDITOR);
    }
}
