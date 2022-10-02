package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.repository.OpportunityRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcOpportunityRepository implements OpportunityRepository {
    @Override
    public Opportunity create(Opportunity entity) {
        return null;
    }

    @Override
    public Optional<Opportunity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<Opportunity> findAll() {
        return null;
    }

    @Override
    public Opportunity update(Opportunity source, Opportunity target) {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
