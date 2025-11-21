package com.ahsansoftware.lms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahsansoftware.lms.dto.StudentRequestDTO;
import com.ahsansoftware.lms.dto.StudentResponseDTO;
import com.ahsansoftware.lms.model.Student;
import com.ahsansoftware.lms.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentResponseDTO convertToDTO(Student student){
        return new StudentResponseDTO(
            student.getId(),
            student.getEmail(),
            student.getName()
        );
    }

    public Student convertToEntity(StudentRequestDTO studentDTO){
        Student student = new Student();
        student.setEmail(studentDTO.getEmail());
        student.setName(studentDTO.getName());
        return student;
    }
    
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                                .stream()
                                .map(this::convertToDTO)
                                .collect(Collectors.toList());           
    }

    public StudentResponseDTO getStudentById(long id){
        Student student = studentRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Student not found with id:"+id));
        return convertToDTO(student);

    }

    public StudentResponseDTO createStudent( StudentRequestDTO studentDTO){
        Student student = convertToEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return convertToDTO(savedStudent);

    }

    public StudentResponseDTO updateStudent(long id ,StudentRequestDTO studentDetails){
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found With Id"+id));
        student.setEmail(studentDetails.getEmail());
        student.setName(studentDetails.getName());
        studentRepository.save(student);
        return convertToDTO(student);
    }
    public String deleteStudent(long id){
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("Student Not Found with id"+id);
        }
        studentRepository.deleteById(id);
        return "Student Deleted with id: "+id;        
    }
}
