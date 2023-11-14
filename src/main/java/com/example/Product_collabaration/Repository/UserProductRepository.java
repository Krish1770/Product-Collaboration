package com.example.Product_collabaration.Repository;

import com.example.Product_collabaration.Entity.UserProduct;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProductRepository extends JpaRepository<UserProduct,Long> {
}
