package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.repository.OpportunityRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class OpportunityRepositoryImpl implements OpportunityRepository {
    private final Map<Long, Opportunity> opportunityMap;

    public OpportunityRepositoryImpl() {
        opportunityMap = new HashMap<>(Map.of(
                1L, new Opportunity(1L, "Java", new Date(System.currentTimeMillis() + 30 * 24 * 60 * 60 * 1000L), false, "Java smth"),
                2L, new Opportunity(2L, "MySQL", new Date(System.currentTimeMillis() + 15 * 24 * 60 * 60 * 1000L), false, "MySQL smth"),
                3L, new Opportunity(3L, "Erazmus", new Date(System.currentTimeMillis() + 60 * 24 * 60 * 60 * 1000L), false, "Erazmus smth"),
                4L, new Opportunity(4L, "JS", new Date(System.currentTimeMillis() + 3 * 24 * 60 * 60 * 1000L), true, "JS smth"),
                5L, new Opportunity(5L, "English", new Date(System.currentTimeMillis() + 5 * 24 * 60 * 60 * 1000L), true, "English smth")
        ));
    }

    @Override
    public Opportunity create(Opportunity entity) {
        entity.setId(opportunityMap.size() + 1L);
        opportunityMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Opportunity findById(Long aLong) {
        return opportunityMap.get(aLong);
    }

    @Override
    public List<Opportunity> findAll() {
        return new ArrayList<>(opportunityMap.values());
    }

    @Override
    public Opportunity update(Opportunity source, Opportunity target) {
        return opportunityMap.replace(target.getId(), source);
    }

    @Override
    public Opportunity delete(Long aLong) {
        return opportunityMap.remove(aLong);
    }
}
