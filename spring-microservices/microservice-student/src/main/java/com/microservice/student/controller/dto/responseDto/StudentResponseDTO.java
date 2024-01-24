package com.microservice.student.controller.dto.responseDto;

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
public class StudentResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String lastName;
    private String email;
}
