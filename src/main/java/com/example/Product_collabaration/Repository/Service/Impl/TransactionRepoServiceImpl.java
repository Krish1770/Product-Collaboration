package com.example.Product_collabaration.Repository.Service.Impl;

import com.example.Product_collabaration.Entity.Transaction;
import com.example.Product_collabaration.Repository.Service.TransactionRepoService;
import com.example.Product_collabaration.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionRepoServiceImpl implements TransactionRepoService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
