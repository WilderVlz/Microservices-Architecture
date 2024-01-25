package com.microservice.course.controller;

import com.microservice.course.controller.dto.request.CourseRequestDTO;
import com.microservice.course.service.ICourseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * This class represents the controller of the course microservice
 * it is responsible for receiving the requests and sending the responses
 */
@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private ICourseService courseService;

    @Operation(summary = "Create a new course")
    @PostMapping("/create")
    public ResponseEntity<?> saveCourse(@Valid @RequestBody CourseRequestDTO course) {
        this.courseService.save(course);
        return new ResponseEntity<>("Course created successfully.", HttpStatus.CREATED);
    }

    @Operation(summary = "Get all courses")
    @GetMapping("/all")
    public ResponseEntity<?> findAllCourses() {
        try {
            return new ResponseEntity<>(this.courseService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return handleException(e, "Error fetching all courses");
        }
    }

    @Operation(summary = "Get a course by id")
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findCourseById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(courseService.findById(id));
        } catch (Exception e) {
            return handleException(e, "Error fetching course by id");
        }
    }

    @Operation(summary = "Get all students by course")
    @GetMapping("/search-student/{idCourse}")
    public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long idCourse) {
        try {
            return ResponseEntity.ok(courseService.findStudentsByIdCourse(idCourse));
        } catch (Exception e) {
            return handleException(e, "Error fetching students by course");
        }
    }

    /**
     * This method handles the exceptions
     *
     * @param e       the exception
     * @param message the message to return
     * @return the response entity with the message and the status
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> handleException(Exception e, String message) {
        return new ResponseEntity<>(message + ": " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
