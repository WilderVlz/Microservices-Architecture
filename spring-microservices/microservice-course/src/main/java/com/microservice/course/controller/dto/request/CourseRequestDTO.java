package com.microservice.course.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @NotBlank(message = "Name is mandatory")
    @NotNull
    private String name;
    @NotBlank(message = "Teacher is mandatory")
    @NotNull
    private String teacher;
}
