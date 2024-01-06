package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
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
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
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
