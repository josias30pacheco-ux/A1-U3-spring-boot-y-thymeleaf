package com.example.estudiantes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.estudiantes.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
