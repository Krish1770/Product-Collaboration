package com.example.Product_collabaration.Repository.Service.Impl;

import com.example.Product_collabaration.Entity.UserProduct;
import com.example.Product_collabaration.Repository.Service.UserProductRepoService;
import com.example.Product_collabaration.Repository.UserProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProductServiceRepoImpl implements UserProductRepoService {

    @Autowired
    private UserProductRepository userProductRepository;
    @Override
    public UserProduct save(UserProduct userProduct) {
        return userProductRepository.save(userProduct);
    }
}
