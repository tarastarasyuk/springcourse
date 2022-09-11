package com.kpi.springcourse.service;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.repository.OpportunityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OpportunityService {

    private OpportunityRepository opportunityRepository;

    public Opportunity create(Opportunity entity) {
        return opportunityRepository.create(entity);
    }

    public Opportunity findById(Long id) {
        return opportunityRepository.findById(id);
    }

    public List<Opportunity> findAll() {
        return opportunityRepository.findAll();
    }

    public Opportunity update(Opportunity source, Opportunity target) {
        return opportunityRepository.update(source, target);
    }

    public Opportunity delete(Long id) {
        return opportunityRepository.delete(id);
    }
}
