package com.example.Product_collabaration.Repository.Service;

import com.example.Product_collabaration.Entity.UserProduct;
import org.springframework.stereotype.Service;

@Service
public interface UserProductRepoService {
    UserProduct save(UserProduct userProduct);
}
