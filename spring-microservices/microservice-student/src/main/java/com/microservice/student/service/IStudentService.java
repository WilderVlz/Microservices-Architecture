package com.microservice.student.service;

//import com.microservice.student.dto.UserDTO;

import com.microservice.student.controller.dto.requestDto.StudentRequestDTO;
import com.microservice.student.controller.dto.responseDto.StudentResponseDTO;
import com.microservice.student.entities.Student;

import java.util.List;

public interface IStudentService {

    List<StudentResponseDTO> findAll();

    Student findById(Long id);

    void save(StudentRequestDTO studentRequestDTO);

    List<StudentResponseDTO> findByIdCourse(Long idCourse);

//    UserDTO findUserById(Long id);
}
