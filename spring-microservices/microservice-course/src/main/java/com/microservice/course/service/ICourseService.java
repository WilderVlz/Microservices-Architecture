package com.microservice.course.service;

import com.microservice.course.controller.dto.request.CourseRequestDTO;
import com.microservice.course.controller.dto.response.CourseResponseDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<CourseResponseDTO> findAll();

    CourseResponseDTO findById(Long id);

    void save(CourseRequestDTO course);

    StudentByCourseResponse findStudentsByIdCourse(Long idCourse);
}
