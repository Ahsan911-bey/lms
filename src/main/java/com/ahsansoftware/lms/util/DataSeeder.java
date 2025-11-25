package com.ahsansoftware.lms.util;

import com.ahsansoftware.lms.model.Student;
import com.ahsansoftware.lms.repository.StudentRepository;
import com.ahsansoftware.lms.repository.UserRepository;
import com.ahsansoftware.lms.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
                new Student(null ,"Ali Ahmed", "ali.ahmed@university.edu"),
                new Student(null ,"John Smith", "john.smith@university.edu"),
                new Student(null ,"Ayesha Raza", "ayesha.raza@university.edu"),
                new Student(null ,"Ali Hassan", "ali.hassan@university.edu")
            );
            
            repository.saveAll(sampleStudents);
            System.out.println("Database seeded with " + sampleStudents.size() + " sample students");
        };
    }

    @Bean
CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    return args -> {
        if (userRepository.count() == 0) {
            userRepository.save(new User(null, "admin", passwordEncoder.encode("admin123"), "admin@university.edu", "ADMIN"));
            userRepository.save(new User(null, "student1", passwordEncoder.encode("password123"), "student1@university.edu", "USER"));
            userRepository.save(new User(null, "ahsan", passwordEncoder.encode("ahsan123"), "ahsan@university.edu", "USER"));
            System.out.println("✅ Database seeded with sample users");
        }
    };
}
}