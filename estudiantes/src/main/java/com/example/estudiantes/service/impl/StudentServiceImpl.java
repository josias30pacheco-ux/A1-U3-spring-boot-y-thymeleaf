package com.example.estudiantes.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.estudiantes.entity.Student;
import com.example.estudiantes.repository.StudentRepository;
import com.example.estudiantes.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(student.getName());
            existing.setEmail(student.getEmail());
            existing.setGrade(student.getGrade());
            return repository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
