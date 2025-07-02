package com.ravinduw.demo.sdr.springdatarelationships;

import com.ravinduw.demo.sdr.springdatarelationships.entity.Course;
import com.ravinduw.demo.sdr.springdatarelationships.entity.Student;
import com.ravinduw.demo.sdr.springdatarelationships.repository.CourseRepo;
import com.ravinduw.demo.sdr.springdatarelationships.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private CourseRepo courseRepo;


    @GetMapping("/test")
    public String getStudent() {

        // Add a new student to the database
        Student student1 = new Student();
        student1.setStudentId("STD0001");
        student1.setFirstName("Ravindu");
        student1.setLastName("Wijesundara");
        student1.setEmail("r@r.com");
        student1.setPhone("00000000000");
        studentRepo.save(student1);

        // Add a new student to the database
        Student student2 = new Student();
        student2.setStudentId("STD0002");
        student2.setFirstName("Test");
        student2.setLastName("Student");
        student2.setEmail("rtt.com");
        student2.setPhone("00000000000");
        studentRepo.save(student2);

        // Add a new student to the database
        Course course1 = new Course();
        course1.setCourseId("SE101");
        course1.setCourseName("Java");
        course1.setField("Programming");
        courseRepo.save(course1);

        // Add a new student to the database
        Course course2 = new Course();
        course2.setCourseId("SE102");
        course2.setCourseName("Python");
        course2.setField("Programming");
        courseRepo.save(course2);


        // Register for the course by building the many-to-many relationships
        student1.getCourses().add(course1);
        student1.getCourses().add(course2);
        studentRepo.save(student1);

        // Register for the course by building the many-to-many relationships
        student2.getCourses().add(course1);
        studentRepo.save(student2);

        return "Done";
    }


}


/*

SQL

CREATE DATABASE lms_db;

CREATE TABLE students (
    student_id VARCHAR(50) NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(60) NOT NULL,
    phone VARCHAR(11) NOT NULL
);

CREATE TABLE courses (
    course_id VARCHAR(50) NOT NULL PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL,
    field VARCHAR(20) NOT NULL
);

CREATE TABLE student_courses (
    student_id VARCHAR(50) NOT NULL,
    course_id VARCHAR(50) NOT NULL,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(course_id) ON DELETE CASCADE
);

 */
