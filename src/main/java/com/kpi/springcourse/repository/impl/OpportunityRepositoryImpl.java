package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.repository.OpportunityRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OpportunityRepositoryImpl implements OpportunityRepository {
    private final Map<Long, Opportunity> opportunityMap;

    public OpportunityRepositoryImpl() {
        opportunityMap = new HashMap<>(Map.of(
                1L, new Opportunity(1L, "Erazmus"),
                2L, new Opportunity(2L, "English"),
                3L, new Opportunity(3L, "Java"),
                4L, new Opportunity(4L, "Excel"),
                5L, new Opportunity(5L, "MySQL")
        ));
    }

    @Override
    public Opportunity create(Opportunity entity) {
        entity.setId(opportunityMap.size() + 1L);
        return opportunityMap.put(entity.getId(), entity);
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
