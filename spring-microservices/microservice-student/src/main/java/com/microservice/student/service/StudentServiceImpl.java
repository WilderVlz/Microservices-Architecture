package com.microservice.student.service;


import com.microservice.student.controller.dto.requestDto.StudentRequestDTO;
import com.microservice.student.controller.dto.responseDto.StudentResponseDTO;
import com.microservice.student.entities.Student;
import com.microservice.student.persistence.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the service of the student microservice
 * it is responsible for the business logic
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<StudentResponseDTO> findAll() {
        List<Student> students = (List<Student>) this.studentRepository.findAll();
        return students.stream()
                .map(student -> StudentResponseDTO.builder()
                        .name(student.getName())
                        .lastName(student.getLastName())
                        .email(student.getEmail())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

    @Override
    public void save(StudentRequestDTO StudentRequestDTO) {

        Student student = Student.builder()
                .name(StudentRequestDTO.getName())
                .lastName(StudentRequestDTO.getLastName())
                .email(StudentRequestDTO.getEmail())
                .courseId(StudentRequestDTO.getCourseId())
                .build();
        studentRepository.save(student);
    }

    @Override
    public List<StudentResponseDTO> findByIdCourse(Long idCourse) {
        List<Student> students = (List<Student>) studentRepository.findAllStudent(idCourse);
        return students.stream()
                .map(student -> StudentResponseDTO.builder()
                        .name(student.getName())
                        .lastName(student.getLastName())
                        .email(student.getEmail())
                        .build())
                .collect(Collectors.toList());
    }
}
