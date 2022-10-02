package com.kpi.springcourse.controller;

import com.kpi.springcourse.dto.StudentDto;
import com.kpi.springcourse.model.Skill;
import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.service.EditorService;
import com.kpi.springcourse.service.SkillService;
import com.kpi.springcourse.service.StudentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final SkillService skillService;
    private final StudentService studentService;
    private final EditorService editorService;

    @ApiOperation(value = "Sign up student", notes = "Calling this endpoint you will register new student")

    @PostMapping("/sign-up")
    public ResponseEntity<Student> signUpStudent(
            @ApiParam(name = "studentDto", required = true, type = "StudentDto", value = "Student information")
            @RequestBody StudentDto studentDto) {
        if (!studentService.checkIfEmailAvailable(studentDto.getEmail())
                || !editorService.checkIfEmailAvailable(studentDto.getEmail())) {
            return new ResponseEntity<>(HttpStatus.IM_USED);
        }

        Set<Skill> skillSet = Arrays.stream(studentDto.getSkills())
                .map(skillService::findByType)
                .collect(Collectors.toSet());

        return new ResponseEntity<>(studentService.create(studentDto.toStudent(skillSet)), HttpStatus.CREATED);
    }
}
