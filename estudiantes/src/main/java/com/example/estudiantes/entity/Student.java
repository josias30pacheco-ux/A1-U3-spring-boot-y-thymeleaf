package com.example.estudiantes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 60, message = "El nombre debe tener entre 2 y 60 caracteres")
    private String name;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debes ingresar un email válido")
    private String email;

    @Min(value = 0, message = "La calificación mínima es 0")
    @Max(value = 100, message = "La calificación máxima es 100")
    private Integer grade;

    public Student() {}

    public Student(String name, String email, Integer grade) {
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getGrade() { return grade; }
    public void setGrade(Integer grade) { this.grade = grade; }
}
