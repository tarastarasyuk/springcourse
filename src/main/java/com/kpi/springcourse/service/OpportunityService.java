package com.kpi.springcourse.service;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.repository.OpportunityRepository;
import com.kpi.springcourse.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
@AllArgsConstructor
public class OpportunityService {

    private OpportunityRepository opportunityRepository;

    private StudentRepository studentRepository;

    public Opportunity create(Opportunity entity) {
        entity.setCreatedAt(Calendar.getInstance().getTime());
        return opportunityRepository.create(entity);
    }

    public Opportunity findById(Long id) {
        return opportunityRepository.findById(id);
    }

    public List<Opportunity> findAll() {
        return opportunityRepository.findAll();
    }

    public Opportunity update(Opportunity source, Opportunity target) {
        source.setCreatedAt(target.getCreatedAt());
        return opportunityRepository.update(source, target);
    }

    public Opportunity delete(Long id) {
        Opportunity opportunity = findById(id);
        studentRepository.findAll()
                .stream()
                .filter(student -> student.getLikedOpportunities().contains(opportunity))
                .forEach(student -> studentRepository.likeUnlikeOpportunity(student, opportunity));
        return opportunityRepository.delete(id);
    }

    public List<Opportunity> findAll(String sort) {
        List<Opportunity> opportunityList = findAll();
        if (nonNull(sort)) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(Calendar.getInstance().getTime());
            cal.add(Calendar.DATE, -3);
            switch (sort) {
                case "newest" -> opportunityList = opportunityList.stream()
                        .sorted(Comparator.comparing(Opportunity::getCreatedAt))
                        .collect(Collectors.toList());
                case "asap" -> opportunityList = opportunityList.stream()
                        .filter(Opportunity::getASAP)
                        .collect(Collectors.toList());
                case "deadline-soon" -> opportunityList = opportunityList.stream()
                        .filter(opportunity -> {
                                    long timeDiff = opportunity.getDeadline().getTime() - Calendar.getInstance().getTime().getTime();
                                    return timeDiff < TimeUnit.DAYS.toMillis(2);
                                }
                        )
                        .collect(Collectors.toList());
                default -> {
                }
            }
        }
        return opportunityList;
    }
}
