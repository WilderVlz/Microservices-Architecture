//package com.microservice.student.client;
//
//import com.microservice.student.dto.UserDTO;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(name = "msvc-security", url = "localhost:8080/api/user")
//public interface UserClient {
//
//    @GetMapping("/{id}")
//    UserDTO findUserById(@PathVariable Long id);
//}
