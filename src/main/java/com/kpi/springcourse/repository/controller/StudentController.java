package com.kpi.springcourse.repository.controller;

import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("students",studentService.findAll());
        return "students";
    }

//    public String updateStudent(Model model, @ModelAttribute Student studentSource, @ModelAttribute Long) {
//        studentService.update()
//        model.addAttribute()
//    }
}
