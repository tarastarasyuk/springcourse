package com.kpi.springcourse.controller;

import com.kpi.springcourse.constants.SpringCourseConstants;
import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.service.OpportunityService;
import com.kpi.springcourse.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class StudentProfileController {

    private StudentService studentService;
    private OpportunityService opportunityService;

    @GetMapping("/students")
    public String getAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpServletRequest request) {
        model.addAttribute("user", studentService.findByEmail((String) request.getSession().getAttribute(SpringCourseConstants.SESSION_AUTH_ATTR)));
        return "profile/index";
    }

    @PostMapping("/profile/unlike/{id}")
    public String unlikeOpportunity(@PathVariable Long id, HttpServletRequest request) {
        studentService.likeUnlikeOpportunity(
                studentService.findByEmail((String) request.getSession().getAttribute("userEmail")),
                opportunityService.findById(id)
        );
        return "redirect:/profile";
    }

    @PostMapping("/profile/save")
    public String saveProfile(@ModelAttribute("user") Student student, Model model, HttpServletRequest request) {
        if (!studentService.checkIfEmailAvailable(student.getEmail()) && !student.getEmail().equals(request.getSession().getAttribute("userEmail"))) {
            model.addAttribute("emailError", "This email is already in use");
            return "profile/index";
        }
        Student updated = studentService.update(student, studentService.findByEmail((String) request.getSession().getAttribute("userEmail")));
        request.getSession().setAttribute("userEmail", updated.getEmail());
        return "redirect:/profile";
    }
}
