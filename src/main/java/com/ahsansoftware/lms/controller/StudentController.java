package com.ahsansoftware.lms.controller;

import com.ahsansoftware.lms.model.Student;
import com.ahsansoftware.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping
    public Optional<Student> getStudentById(@PathVariable long id){
        return studentRepository.findById(id);
    }
}
