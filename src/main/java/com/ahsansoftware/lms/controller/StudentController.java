package com.ahsansoftware.lms.controller;

import com.ahsansoftware.lms.model.Student;
import com.ahsansoftware.lms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id , @RequestBody Student studentDetails){
        return studentService.updateStudent(id, studentDetails);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }
}
