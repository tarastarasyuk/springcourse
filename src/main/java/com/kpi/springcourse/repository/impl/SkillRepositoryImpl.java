package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.repository.SkillRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class SkillRepositoryImpl implements SkillRepository {

    private final Map<Long, Skill> skillMap;

    public SkillRepositoryImpl() {
        skillMap = new HashMap<>(Map.of(
                1L, new Skill(1L, "Java"),
                2L, new Skill(2L, "MySQL"),
                3L, new Skill(3L, "Erazmus"),
                4L, new Skill(4L, "JS"),
                5L, new Skill(5L, "English")
        ));
    }

    @Override
    public Skill create(Skill entity) {
        entity.setId(skillMap.size() + 1L);
        skillMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Skill findById(Long aLong) {
        return skillMap.get(aLong);
    }

    @Override
    public List<Skill> findAll() {
        return new ArrayList<>(skillMap.values());
    }

    @Override
    public Skill update(Skill source, Skill target) {
        return skillMap.replace(target.getId(), source);
    }

    @Override
    public Skill delete(Long aLong) {
        return skillMap.remove(aLong);
    }

    @Override
    public Optional<Skill> findByType(String type) {
        return skillMap.values().stream()
                .filter(skill -> skill.getType().equals(type))
                .findAny();
    }
}
