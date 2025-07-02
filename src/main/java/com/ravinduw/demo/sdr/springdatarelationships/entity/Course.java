package com.ravinduw.demo.sdr.springdatarelationships.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @Getter
    @Setter
    @Column(name = "course_id")
    private String courseId;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    @Getter
    @Setter
    @Column(name = "course_name")
    private String courseName;

    @Getter
    @Setter
    @Column(name = "field")
    private String field;

}
