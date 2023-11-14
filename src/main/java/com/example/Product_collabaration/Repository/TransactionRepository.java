package com.example.Product_collabaration.Repository;


import com.example.Product_collabaration.Entity.Transaction;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
