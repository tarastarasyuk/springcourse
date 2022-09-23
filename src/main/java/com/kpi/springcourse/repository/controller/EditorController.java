package com.kpi.springcourse.repository.controller;

import com.kpi.springcourse.service.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editor")
public class EditorController {

    @Autowired
    private EditorService editorService;

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("editors",editorService.findAll());
        return "editors";
    }
}
