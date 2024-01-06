package com.microservice.course.http.response;

import com.microservice.course.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/* this is the class that will be in charge of returning the response
of the students by course to the final client (gateway microservice) */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentByCourseResponse {
    /* this are the fields that we are going to return to the client
    and we can customize the response as we want
     */
    private String courseName;
    private String teacher;
    private List<StudentDTO> studentDTOList;
}
