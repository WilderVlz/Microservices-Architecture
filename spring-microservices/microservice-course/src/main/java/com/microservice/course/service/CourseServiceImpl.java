package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.controller.dto.request.CourseRequestDTO;
import com.microservice.course.controller.dto.response.CourseResponseDTO;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseRepository courseRepository;

    @Autowired
    // this is the client that allows us to communicate with the student microservice
    private StudentClient studentClient;

    @Override
    public List<CourseResponseDTO> findAll() {
        List<Course> courses = (List<Course>) this.courseRepository.findAll();
        return courses.stream()
                .map(course -> CourseResponseDTO.builder()
                        .name(course.getName())
                        .teacher(course.getTeacher())
                        .build())
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public CourseResponseDTO findById(Long id) {
        Course course = this.courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with ID: " + id));

        return CourseResponseDTO.builder()
                .name(course.getName())
                .teacher(course.getTeacher())
                .build();
    }

    @Override
    public void save(CourseRequestDTO course) {
        Course courseEntity = Course.builder()
                .name(course.getName())
                .teacher(course.getTeacher())
                .build();
        this.courseRepository.save(courseEntity);
    }

    // this method communicates with the student microservice using the client we inject
    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse) {

        // consult the course by id
        Course course = courseRepository.findById(idCourse).orElse(new Course());

        // get all the students of the course
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        // this works thanks to the fact that we have the @Build annotation in the entity and the DTO
        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
