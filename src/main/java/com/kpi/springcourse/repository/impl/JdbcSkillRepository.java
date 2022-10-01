package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.repository.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class JdbcSkillRepository implements SkillRepository {

    private JdbcTemplate jdbcTemplate;

    @Override
    public Skill create(Skill entity) {
        return null;
    }

    @Override
    public Skill findById(Long aLong) {
        return null;
    }

    @Override
    public List<Skill> findAll() {
        return null;
    }

    @Override
    public Skill update(Skill source, Skill target) {
        return null;
    }

    @Override
    public Skill delete(Long aLong) {
        return null;
    }

    @Override
    public Optional<Skill> findByType(String type) {
        return Optional.empty();
    }
}
