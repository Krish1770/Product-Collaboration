package com.example.Product_collabaration.Repository.Service;

import com.example.Product_collabaration.DTO.ResponseDTO;
import com.example.Product_collabaration.Entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public interface ProductRepoService {


    Product save(Product product);

   Optional<Product> findById(Long productId);

    public List<Product> findByIdIn(List<Long> arrayList);
}
