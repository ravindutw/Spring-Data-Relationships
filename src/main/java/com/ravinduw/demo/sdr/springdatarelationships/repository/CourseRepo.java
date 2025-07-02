package com.ravinduw.demo.sdr.springdatarelationships.repository;

import com.ravinduw.demo.sdr.springdatarelationships.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, String> {
    Course findByCourseId(String courseId);
}

