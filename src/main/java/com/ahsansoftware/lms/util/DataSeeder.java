package com.ahsansoftware.lms.util;

import com.ahsansoftware.lms.model.Student;
import com.ahsansoftware.lms.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(StudentRepository repository) {
        return args -> {
            // Clear existing data and start fresh (optional)
            repository.deleteAll();
            
            List<Student> sampleStudents = Arrays.asList(
                new Student(null , "Ahsan Khan", "ahsan.khan@university.edu"),
                new Student(null ,"Ali Ahmed", "maria.ahmed@university.edu"),
                new Student(null ,"John Smith", "john.smith@university.edu"),
                new Student(null ,"Ayesha Raza", "fatima.raza@university.edu"),
                new Student(null ,"Ali Hassan", "ali.hassan@university.edu")
            );
            
            repository.saveAll(sampleStudents);
            System.out.println("✅ Database seeded with " + sampleStudents.size() + " sample students");
        };
    }
}