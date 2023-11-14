package com.example.Product_collabaration.Controller;

import com.example.Product_collabaration.Api.ProductApi;
import com.example.Product_collabaration.DTO.ProductUpdateDTO;
import com.example.Product_collabaration.DTO.ResponseDTO;
import com.example.Product_collabaration.Entity.Product;
import com.example.Product_collabaration.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {

    @Autowired
    private ProductService productService;


    @Override
    public ResponseEntity<ResponseDTO> addProducts(Product product) {
        return productService.addProducts(product);
    }

    @Override
    public ResponseEntity<ResponseDTO> updateProducts(Long productId,ProductUpdateDTO productUpdateDTO) {
        return productService.updateProducts(productId,productUpdateDTO);
    }

    @Override
    public ResponseEntity<ResponseDTO> getCollaborators(Long productId) {
        return productService.getCollaborators(productId);
    }
}
