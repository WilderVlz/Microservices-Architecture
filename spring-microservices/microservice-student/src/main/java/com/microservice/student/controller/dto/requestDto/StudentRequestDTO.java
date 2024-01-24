package com.microservice.student.controller.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
public class StudentRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Last name is mandatory")
    private String lastName;
    @Email(message = "Email is not valid")
    @NotBlank(message = "Email is mandatory")
    private String email;
    private Long courseId;
}
