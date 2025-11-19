package com.ahsansoftware.lms.service;

import com.ahsansoftware.lms.model.Student;
import com.ahsansoftware.lms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id){
        return studentRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Student not found with id:"+id));

    }

    public Student createStudent( Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(long id ,Student studentDetails){
        Student student = studentRepository.findById(id).orElseThrow();
        student.setEmail(studentDetails.getEmail());
        student.setName(studentDetails.getName());
        return studentRepository.save(student);
    }
    public String deleteStudent(long id){
        studentRepository.deleteById(id);
        return "Student Deleted with id: "+id;
    }
}
