package com.kpi.springcourse.repository;

import com.kpi.springcourse.model.User;

import java.util.Optional;

public interface UserRepository<T extends User, ID> extends CrudRepository<T, ID> {
    Optional<T> findByEmail(String email);

    boolean checkIfEmailAvailable(String email);
}
