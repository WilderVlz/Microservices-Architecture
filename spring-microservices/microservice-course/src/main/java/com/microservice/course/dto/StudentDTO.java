package com.microservice.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    // it's not necessary to add the id field since we are not going to use it
    private String name;
    private String lastName;
    private String email;
}
