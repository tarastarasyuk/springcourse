package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.repository.SkillRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcSkillRepository implements SkillRepository {
    @Override
    public Skill create(Skill entity) {
        return null;
    }

    @Override
    public Optional<Skill> findById(Long aLong) {
        return Optional.empty();
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
    public void delete(Long aLong) {

    }

    @Override
    public Optional<Skill> findByType(String type) {
        return Optional.empty();
    }
}
