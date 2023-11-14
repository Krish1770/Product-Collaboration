package com.example.Product_collabaration.Api;


import com.example.Product_collabaration.DTO.PurchaseDTO;
import com.example.Product_collabaration.DTO.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("UserProduct/")
public interface UserProductApi
{
    @PostMapping("add")
    ResponseEntity<ResponseDTO> addUserProduct(@RequestBody PurchaseDTO purchaseDTO);
}
