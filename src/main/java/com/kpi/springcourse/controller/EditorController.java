package com.kpi.springcourse.controller;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/editor/opportunities")
public class EditorController {

    @Autowired
    private OpportunityService opportunitiesService;

    @GetMapping("")
    public String getAll(Model model, @RequestParam(value = "sort", required = false) String sort) {
        model.addAttribute("opportunities", opportunitiesService.findAll(sort));
        return "opportunities/table";
    }

    @GetMapping("/create")
    public String getCreationFormOpportunity(Model model) {
        Opportunity opportunityToCreate = new Opportunity();
        opportunityToCreate.setASAP(false);
        model.addAttribute("opportunityToCreate", opportunityToCreate);
        return "opportunities/create";
    }

    @PostMapping("/create")
    public String createOpportunity(@ModelAttribute("opportunityToCreate") Opportunity opportunityToCreate) {
        long id = opportunitiesService.create(opportunityToCreate).getId();
        return "redirect:/editor/opportunities#" + id;
    }

    @GetMapping("/edit/{id}")
    public String editOpportunity(Model model, @PathVariable Long id) {
        Opportunity opportunityToUpdate = opportunitiesService.findById(id);
        model.addAttribute("opportunityToEdit", opportunityToUpdate);
        return "/opportunities/edit";
    }

    @PostMapping("/edit/{id}")
    public String editOpportunity(@ModelAttribute("opportunityToEdit") Opportunity opportunityToUpdate, @PathVariable Long id) {
        Opportunity targetOpportunity = opportunitiesService.findById(id);
        opportunitiesService.update(opportunityToUpdate, targetOpportunity);
        return "redirect:/editor/opportunities#" + id;
    }

    @PostMapping("/delete/{id}")
    public String deleteOpportunity(@PathVariable Long id) {
        opportunitiesService.delete(id);
        return "redirect:/editor/opportunities";
    }

}
