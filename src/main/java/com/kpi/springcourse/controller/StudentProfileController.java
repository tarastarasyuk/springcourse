package com.kpi.springcourse.controller;

import com.kpi.springcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentProfileController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }
}
