package com.example.Product_collabaration.Repository.Service.Impl;

import com.example.Product_collabaration.DTO.ResponseDTO;
import com.example.Product_collabaration.Entity.Product;
import com.example.Product_collabaration.Repository.ProductRepository;
import com.example.Product_collabaration.Repository.Service.ProductRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductRepoServiceImpl implements ProductRepoService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return  productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> findByIdIn(List<Long> arrayList) {


        return productRepository.findAllById(arrayList);
    }

}
