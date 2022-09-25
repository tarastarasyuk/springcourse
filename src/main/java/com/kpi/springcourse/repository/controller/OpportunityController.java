package com.kpi.springcourse.repository.controller;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.service.OpportunityService;
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

    @GetMapping("/create")
    public String getCreationFormOpportunity(@ModelAttribute("opportunityToCreate") Opportunity opportunityToCreate) {
        return "opportunities/create";
    }

    @PostMapping("/create")
    public String createOpportunity(@ModelAttribute("opportunityToCreate") Opportunity opportunityToCreate) {
        long id = opportunitiesService.create(opportunityToCreate).getId();
        return "redirect:/opportunities#" + id;
    }

    @GetMapping("/edit")
    public String table(Model model) {
        model.addAttribute("opportunities", opportunitiesService.findAll());
        return "opportunities/table";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        Opportunity opportunityToUpdate = opportunitiesService.findById(id);
        model.addAttribute("opportunityToEdit", opportunityToUpdate);
        return "opportunities/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute("opportunityToEdit") Opportunity opportunityToUpdate, @PathVariable Long id) {
        Opportunity targetOpportunity = opportunitiesService.findById(id);
        opportunitiesService.update(opportunityToUpdate, targetOpportunity);
        return "redirect:/opportunities#" + id;
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        opportunitiesService.delete(id);
        return "redirect:/opportunities";
    }
}
