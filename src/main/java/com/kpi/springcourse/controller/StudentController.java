package com.kpi.springcourse.controller;

import com.kpi.springcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }
}
