package com.ravinduw.demo.sdr.springdatarelationships.repository;

import com.ravinduw.demo.sdr.springdatarelationships.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, String> {
    Student findByStudentId(String studentId);
}
