package com.kpi.springcourse.controller;

import com.kpi.springcourse.constants.SpringCourseConstants;
import com.kpi.springcourse.dto.StudentDto;
import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.model.User;
import com.kpi.springcourse.service.EditorService;
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
    private final EditorService editorService;

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in/index";
    }

    @PostMapping("/sign-in")
    public String signIn(HttpServletRequest request, Model model) {
        String emailRequest = request.getParameter("email");
        if (studentService.checkIfEmailAvailable(emailRequest) && editorService.checkIfEmailAvailable(emailRequest)) {
            model.addAttribute("emailError", "User with this email does not exist");
            return "sign-in/index";
        }

        User user;
        try{
            user = studentService.findByEmail(emailRequest);
        } catch (RuntimeException ex) {
            user = editorService.findByEmail(emailRequest);
        }
        request.getSession().setAttribute(SpringCourseConstants.SESSION_AUTH_ATTR, emailRequest);
        request.getSession().setAttribute(SpringCourseConstants.SESSION_AUTH_ATTR_ROLE, user.getRole().name());
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute(SpringCourseConstants.SESSION_AUTH_ATTR);
        request.getSession().removeAttribute(SpringCourseConstants.SESSION_AUTH_ATTR_ROLE);
        return "redirect:/";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model, @ModelAttribute("userToSignUp") StudentDto studentDto) {
        model.addAttribute("skillsToSelect", skillService.findAll());
        return "sign-up/index";
    }

    @PostMapping("/sign-up")
    public String signUpStudent(@ModelAttribute("userToSignUp") StudentDto studentDto, Model model) {
        if (!studentService.checkIfEmailAvailable(studentDto.getEmail())) {
            model.addAttribute("emailError", "This email is already in use");
            model.addAttribute("skillsToSelect", skillService.findAll());
            return "sign-up/index";
        }

        Set<Skill> skillSet = Arrays.stream(studentDto.getSkills())
                .map(skillService::findByType)
                .collect(Collectors.toSet());

        studentService.create(studentDto.toStudent(skillSet));
        return "redirect:/";
    }
}
