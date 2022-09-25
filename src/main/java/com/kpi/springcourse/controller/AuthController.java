package com.kpi.springcourse.controller;

import com.kpi.springcourse.dto.StudentDto;
import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.service.SkillService;
import com.kpi.springcourse.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final SkillService skillService;
    private final StudentService studentService;

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in/index";
    }

    @PostMapping("/sign-in")
    public String signInStudent(HttpServletRequest request) {
        request.getSession().setAttribute("userEmail", request.getParameter("email"));
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logoutStudent(HttpServletRequest request) {
        request.getSession().removeAttribute("userEmail");
        return "redirect:/";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model, @ModelAttribute("userToSignUp") StudentDto studentDto) {
        model.addAttribute("skillsToSelect", skillService.findAll());
        return "sign-up/index";
    }

    @PostMapping("/sign-up")
    public String signUpStudent(@ModelAttribute("userToSignUp") StudentDto studentDto) {
        Set<Skill> skillSet = Arrays.stream(studentDto.getSkills())
                .map(skillService::findByType)
                .collect(Collectors.toSet());

        studentService.create(studentDto.toStudent(skillSet));
        return "redirect:/";
    }
}
