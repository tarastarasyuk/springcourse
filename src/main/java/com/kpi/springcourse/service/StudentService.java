package com.kpi.springcourse.service;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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

    public void likeUnlikeOpportunity(Student student, Opportunity opportunity) {
        studentRepository.likeUnlikeOpportunity(student, opportunity);
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email).orElseThrow(IllegalArgumentException::new);
    }

    public boolean isLiked(Student student, Opportunity opportunity) {
        return student.getLikedOpportunities().contains(opportunity);
    }

    public boolean isLiked(String userEmail, Opportunity opportunity) {
        return findByEmail(userEmail).getLikedOpportunities().contains(opportunity);
    }

    public boolean checkIfEmailAvailable(String email) {
        return studentRepository.checkIfEmailAvailable(email);
    }
}
