package com.kpi.springcourse.service;

import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.repository.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkillService {
    private SkillRepository skillRepository;

    public Skill create(Skill entity) {
        return skillRepository.create(entity);
    }

    public Skill findById(Long id) {
        return skillRepository.findById(id);
    }

    public Skill findByType(String type) {
        return skillRepository.findByType(type).orElseThrow(IllegalArgumentException::new);
    }

    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    public Skill update(Skill source, Skill target) {
        return skillRepository.update(source, target);
    }

    public Skill delete(Long id) {
        return skillRepository.delete(id);
    }
}
