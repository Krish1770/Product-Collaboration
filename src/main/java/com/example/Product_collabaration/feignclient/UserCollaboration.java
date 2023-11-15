package com.example.Product_collabaration.feignclient;


import com.example.Product_collabaration.DTO.ResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "USER-COLLABORATION")
public interface UserCollaboration
{
    @GetMapping("/User/get/{userId}")
    ResponseEntity<ResponseDTO> getUser(@PathVariable Long userId);
}
