package com.example.Product_collabaration.Repository.Service;

import com.example.Product_collabaration.Entity.Transaction;
import com.example.Product_collabaration.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public interface TransactionRepoService {
    Transaction save(Transaction transaction);
}
