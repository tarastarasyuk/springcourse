package com.kpi.springcourse.repository.impl;

import com.kpi.springcourse.model.Opportunity;
import com.kpi.springcourse.model.Student;
import com.kpi.springcourse.repository.SkillRepository;
import com.kpi.springcourse.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@AllArgsConstructor
public class StudentRepositoryImpl implements StudentRepository {
    private final Map<Long, Student> studentMap;

    private SkillRepositoryImpl skillRepository = new SkillRepositoryImpl();

    public StudentRepositoryImpl() {
        studentMap = new HashMap<>(Map.of(
                1L, new Student(1L, "test1@tat.ss", "Taras", "Tarasiuk", 34, "094345342", Set.of(skillRepository.findById(1L))),
                2L, new Student(2L, "test2@tat.ss", "Roman", "Bondarenko", 67, "085345233", Set.of(skillRepository.findById(2L))),
                3L, new Student(3L, "test3@tat.ss", "Nadia", "Prokhorchuk", 12, "034523452", Set.of(skillRepository.findById(3L))),
                4L, new Student(4L, "test4@tat.ss", "Bob", "Bobuk", 19, "043454452", Set.of(skillRepository.findById(4L))),
                5L, new Student(5L, "test5@tat.ss", "Sam", "Samuk", 16, "03454523452", Set.of(skillRepository.findById(5L))),
                6L, new Student(6L, "test6@tat.ss", "Bill", "Billuk", 62, "034554423452", Set.of(skillRepository.findById(1L))),
                7L, new Student(7L, "test7@tat.ss", "Kate", "Katuk", 21, "03454323452", Set.of(skillRepository.findById(2L))))
        );
    }

    @Override
    public Student create(Student entity) {
        entity.setId(studentMap.size() + 1L);
        studentMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Student findById(Long aLong) {
        return studentMap.get(aLong);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public Student update(Student source, Student target) {
        source.setId(target.getId());
        source.setSkills(target.getSkills());
        source.setLikedOpportunities(target.getLikedOpportunities());
        studentMap.put(target.getId(), source);
        return source;
    }

    @Override
    public Student delete(Long aLong) {
        return studentMap.remove(aLong);
    }

    @Override
    public void likeUnlikeOpportunity(Student student, Opportunity opportunity) {
        Set<Opportunity> likedOpportunities = student.getLikedOpportunities();
        if (likedOpportunities.contains(opportunity)) likedOpportunities.remove(opportunity);
        else likedOpportunities.add(opportunity);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentMap.values().stream()
                .filter(student -> student.getEmail().equals(email))
                .findAny();
    }

    @Override
    public boolean checkIfEmailAvailable(String email) {
        return studentMap.values().stream()
                .noneMatch(student -> student.getEmail().equals(email));
    }
}
