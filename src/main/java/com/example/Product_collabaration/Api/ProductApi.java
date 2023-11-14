package com.example.Product_collabaration.Api;


import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.example.Product_collabaration.DTO.ProductUpdateDTO;
import com.example.Product_collabaration.DTO.ResponseDTO;
import com.example.Product_collabaration.Entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RequestMapping("/Product")
public interface ProductApi {

    @PostMapping("/add")
    ResponseEntity<ResponseDTO> addProducts(@RequestBody Product product);

    @PostMapping("update/{productId}")
    ResponseEntity<ResponseDTO> updateProducts(@PathVariable Long productId, @RequestBody ProductUpdateDTO productUpdateDTO);

    @GetMapping("getCollaborators/{productId}")
    ResponseEntity<ResponseDTO> getCollaborators(@PathVariable Long productId);
}
