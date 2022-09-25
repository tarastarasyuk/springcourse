package com.kpi.springcourse.controller;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.service.OpportunityService;
import com.kpi.springcourse.service.SkillService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Setter
@Controller
@AllArgsConstructor
@RequestMapping("/opportunities")
public class OpportunityController {

    private OpportunityService opportunitiesService;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("opportunities", opportunitiesService.findAll());

        // todo: check if user logged in
        // for now, we assume that user is always logged in
        return "opportunities/list";
    }

    @PostMapping("/like/{id}")
    public String likeOpportunity(@PathVariable Long id) {
        log.info("You liked opportunity {}: {}", id, opportunitiesService.findById(id));
        return "redirect:/opportunities#" + id;
    }

}
