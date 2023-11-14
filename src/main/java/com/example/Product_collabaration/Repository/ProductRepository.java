package com.example.Product_collabaration.Repository;

import com.example.Product_collabaration.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
//    List<Product> findAllByProductId(List<Long> arrayList);

}
