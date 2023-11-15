package com.example.Product_collabaration.feignclient;


import com.example.Product_collabaration.DTO.ResponseDTO;
//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "MESSAGE-COLLABORATION" ,url = "http://localhost:8082")
@FeignClient(value = "MESSAGE-COLLABORATION")
public interface MessageCollaboration {

    @GetMapping("Message/getCollaborators/{productId}")
    ResponseEntity<ResponseDTO>  getCollaborators(@PathVariable Long productId);

}
