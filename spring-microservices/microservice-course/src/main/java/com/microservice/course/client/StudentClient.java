package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/* this is the name of the microservice to which we are going to connect
 this name is the same as the one we put in the application.yml file
 */
// url is the url of the microservice to which we are going to connect
@FeignClient(name = "micro-student-compose", url = "http://micro-student-compose:8030/api/student")
public interface StudentClient {
    /* this would be all the necessary feign will take care of making the entire http request
     * and return the response in the format that we indicate in this case
     */
    @GetMapping("/search-by-course/{idCourse}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long idCourse);
}
