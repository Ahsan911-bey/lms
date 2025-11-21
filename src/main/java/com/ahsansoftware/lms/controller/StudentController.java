package com.ahsansoftware.lms.controller;

import com.ahsansoftware.lms.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

import com.ahsansoftware.lms.dto.StudentRequestDTO;
import com.ahsansoftware.lms.dto.StudentResponseDTO;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    
    @GetMapping
    public List<StudentResponseDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public StudentResponseDTO createStudent(@Valid @RequestBody StudentRequestDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable long id ,@Valid @RequestBody StudentRequestDTO studentDetails){
        return studentService.updateStudent(id, studentDetails);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }
}
