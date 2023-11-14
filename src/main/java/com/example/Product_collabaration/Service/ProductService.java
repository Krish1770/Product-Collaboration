package com.example.Product_collabaration.Service;

import com.example.Product_collabaration.DTO.ProductUpdateDTO;
import com.example.Product_collabaration.DTO.ResponseDTO;
import com.example.Product_collabaration.Entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface ProductService {
    ResponseEntity<ResponseDTO> addProducts(Product product);

    ResponseEntity<ResponseDTO> updateProducts(Long productId,ProductUpdateDTO productUpdateDTO);

    ResponseEntity<ResponseDTO> getCollaborators(Long productId);
}
