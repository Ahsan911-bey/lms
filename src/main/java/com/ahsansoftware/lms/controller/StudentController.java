package com.ahsansoftware.lms.controller;

import com.ahsansoftware.lms.model.Student;
import com.ahsansoftware.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable long id){
        return studentRepository.findById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable long id , @RequestBody Student studentDetails){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setEmail(studentDetails.getEmail());
        student.setName(studentDetails.getName());
        return studentRepository.save(student);
    }
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable long id){
        studentRepository.deleteById(id);
        return "Student Deleted with id: "+id;
    }
}
