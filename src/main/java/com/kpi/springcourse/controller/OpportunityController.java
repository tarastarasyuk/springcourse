package com.kpi.springcourse.controller;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.service.OpportunityService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Setter
@RequestMapping("/opportunities")
@Controller
@AllArgsConstructor
public class OpportunityController {

    private OpportunityService opportunitiesService;

    // todo: provide opportunities by user email
    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("opportunities", opportunitiesService.findAll());
        return "opportunities/not-signed-in";
    }

    @GetMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id) {
        Opportunity opportunityToUpdate = opportunitiesService.findById(id);
        model.addAttribute("opportunityToUpdate", opportunityToUpdate);
        return "opportunities/create";
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("opportunityToUpdate") Opportunity opportunityToUpdate, @PathVariable Long id) {
        Opportunity targetOpportunity = opportunitiesService.findById(id);
        opportunitiesService.update(opportunityToUpdate, targetOpportunity);
        return "redirect:/opportunities/not-signed-in";
    }

    @GetMapping("/create")
    public String getCreationFormOpportunity(@ModelAttribute("opportunityToCreate") Opportunity opportunityToCreate) {
        return "opportunities/create";
    }

    @PostMapping("/create")
    public String createOpportunity(@ModelAttribute("opportunityToCreate") Opportunity opportunityToCreate) {
        opportunitiesService.create(opportunityToCreate);
        return "redirect:/opportunities/not-signed-in";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        opportunitiesService.delete(id);
        return "redirect:/opportunities/not-signed-in";
    }
}
