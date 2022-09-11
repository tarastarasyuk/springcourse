package com.kpi.springcourse.repository;

import java.util.List;

public interface CrudRepository<E, ID> {
    E create(E entity);
    E findById(ID id);
    List<E> findAll();
    E update(E source, E target);
    E delete(ID id);
}
