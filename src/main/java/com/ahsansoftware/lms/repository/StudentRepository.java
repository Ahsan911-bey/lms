package com.ahsansoftware.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ahsansoftware.lms.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student , Long> {

}
