package com.kpi.springcourse.service;

import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StudentService {

    private StudentRepository studentRepository;

    public Student create(Student entity) {
        return studentRepository.create(entity);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student update(Student source, Student target) {
        return studentRepository.update(source, target);
    }

    public Student delete(Long id) {
        return studentRepository.delete(id);
    }

}
