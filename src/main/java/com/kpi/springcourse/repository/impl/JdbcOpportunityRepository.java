package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.repository.OpportunityRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class JdbcOpportunityRepository implements OpportunityRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Opportunity create(Opportunity entity) {
        // rs ext
        return null;
    }

    @Override
    public Opportunity findById(Long aLong) {
        return null;
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
    public Opportunity delete(Long aLong) {
        return null;
    }
}
