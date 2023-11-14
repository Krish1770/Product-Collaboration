package com.example.Product_collabaration.Controller;

import com.example.Product_collabaration.Api.UserProductApi;
import com.example.Product_collabaration.DTO.PurchaseDTO;
import com.example.Product_collabaration.DTO.ResponseDTO;
import com.example.Product_collabaration.Service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserProductController implements UserProductApi {

    @Autowired
    private UserProductService userProductService;
    @Override
    public ResponseEntity<ResponseDTO> addUserProduct(PurchaseDTO purchaseDTO) {
      return  userProductService.addUserProduct(purchaseDTO);

    }
}
