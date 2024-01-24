package com.microservice.student.controller;

import com.microservice.student.controller.dto.requestDto.StudentRequestDTO;
import com.microservice.student.controller.dto.responseDto.StudentResponseDTO;
import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class represents the controller of the student microservice
 * it is responsible for receiving the requests and sending the responses
 */
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Operation(summary = "Create a new student")
    @PostMapping("/create")
    public ResponseEntity<?> saveStudent(@Valid @RequestBody StudentRequestDTO studentRequestDTO) {
        try {
            this.studentService.save(studentRequestDTO);
            return new ResponseEntity<>("Student created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating student: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get all students")
    @GetMapping("/all")
    public ResponseEntity<?> findAllStudent() {
        try {
            return new ResponseEntity<>(this.studentService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching all students: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get a student by id")
    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Student student = studentService.findById(id);
            if (student != null) {
                return ResponseEntity.ok(student);
            } else {
                return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching student by id: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Operation(summary = "Get all students by course")
    @GetMapping("/search-by-course/{idCourse}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long idCourse) {
        try {
            List<StudentResponseDTO> students = this.studentService.findByIdCourse(idCourse);
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error fetching students by course: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
