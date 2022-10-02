package com.kpi.springcourse.repository;

import com.kpi.springcourse.model.Skill;

import java.util.Optional;

public interface SkillRepository extends CrudRepository<Skill, Long> {
    Optional<Skill> findByType(String type);
}
