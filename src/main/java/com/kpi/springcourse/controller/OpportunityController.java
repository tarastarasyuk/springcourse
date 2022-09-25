package com.kpi.springcourse.controller;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.service.OpportunityService;
import com.kpi.springcourse.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Setter
@Controller
@AllArgsConstructor
@RequestMapping("/opportunities")
public class OpportunityController {

    private OpportunityService opportunitiesService;
    private StudentService studentService;

    @GetMapping()
    public String getAll(Model model, HttpServletRequest request) {
        model.addAttribute("user", request.getSession().getAttribute("userEmail"));
        model.addAttribute("opportunities", opportunitiesService.findAll());
        model.addAttribute("studentService", studentService);
        return "opportunities/list";
    }

    @PostMapping("/like/{id}")
    public String likeOpportunity(@PathVariable Long id, HttpServletRequest request) {
        toggleLike(id, request);
        return "redirect:/opportunities#" + id;
    }

    @PostMapping("/unlike/{id}")
    public String unlikeOpportunity(@PathVariable Long id, HttpServletRequest request) {
        toggleLike(id, request);
        return "redirect:/opportunities#" + id;
    }

    private void toggleLike(Long opportunityId, HttpServletRequest request) {
        Student byEmail = studentService.findByEmail((String) request.getSession().getAttribute("userEmail"));
        studentService.likeUnlikeOpportunity(
                byEmail,
                opportunitiesService.findById(opportunityId)
        );
        log.info(byEmail.toString());
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
