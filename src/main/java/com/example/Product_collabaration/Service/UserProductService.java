package com.example.Product_collabaration.Service;

import com.example.Product_collabaration.DTO.PurchaseDTO;
import com.example.Product_collabaration.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserProductService {
    ResponseEntity<ResponseDTO> addUserProduct(PurchaseDTO purchaseDTO);
}
