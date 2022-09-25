package com.kpi.springcourse.model;

public class Editor extends User {
    public Editor(Long id, String email) {
        super(id, email, Role.ROLE_EDITOR);
    }
}
