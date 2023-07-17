package com.tpe.service;


import com.tpe.domain.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    void saveCourse (Course course);

    List<Course> getAllCourse ();

    Course getById (Long id);
    void delete (Long id);

}
