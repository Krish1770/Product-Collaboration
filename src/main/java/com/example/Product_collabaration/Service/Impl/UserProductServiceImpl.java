package com.example.Product_collabaration.Service.Impl;

import com.example.Product_collabaration.DTO.PurchaseDTO;
import com.example.Product_collabaration.DTO.ResponseDTO;
import com.example.Product_collabaration.Entity.Product;
import com.example.Product_collabaration.Entity.Transaction;
import com.example.Product_collabaration.Entity.UserProduct;
import com.example.Product_collabaration.Repository.Service.ProductRepoService;
import com.example.Product_collabaration.Repository.Service.TransactionRepoService;
import com.example.Product_collabaration.Repository.Service.UserProductRepoService;
import com.example.Product_collabaration.Service.ProductService;
import com.example.Product_collabaration.Service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserProductServiceImpl implements UserProductService {

    @Autowired
    private ProductRepoService productRepoService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserProductRepoService userProductRepoService;

    @Autowired
    private TransactionRepoService transactionRepoService;
    @Override
    public ResponseEntity<ResponseDTO> addUserProduct(PurchaseDTO purchaseDTO) {



     String url="http//localhost/User/isUser/"+purchaseDTO.getUserId();

     ResponseDTO responseDTO=restTemplate.getForObject(url, ResponseDTO.class);
     if(responseDTO.getData().equals("true"))
     {

         List<Long> invalidProducts=new ArrayList<>();

         // to denote there are some invalid products in the list
         boolean invalidFlag = false;

         List<UserProduct> userProductList=new ArrayList<>();
         Transaction transaction=Transaction.builder()
                 .userId(purchaseDTO.getUserId()).build();

         Transaction transaction1=transactionRepoService.save(transaction);

   UserProduct userProduct=new UserProduct();
   UserProduct savedUserProduct=new UserProduct();
         for(Long j :purchaseDTO.getProductIdWithQuantity().keySet()) {

            Optional<Product> product=productRepoService.findById(j);
            if (product.isEmpty()) {
                 invalidProducts.add(j);
                 invalidFlag=true;
                 continue;
            }
             userProduct = UserProduct.builder()
                     .transactionId(transaction1)
                     .productId(productRepoService.findById(j).get())
                     .quantity(purchaseDTO.getProductIdWithQuantity().get(j))
                     .amount(productRepoService.findById(j).get().getAmount() *
                             purchaseDTO.getProductIdWithQuantity().get(j))
                     .build();

             savedUserProduct = userProductRepoService.save(userProduct);

             userProductList.add(savedUserProduct);
         }
         if(!invalidFlag)
          return ResponseEntity.status(HttpStatus.OK).body( new ResponseDTO(HttpStatus.OK,"transactions saved",savedUserProduct));
        else
             return ResponseEntity.status(HttpStatus.OK).body( new ResponseDTO(HttpStatus.OK,"transactions saved but the product ids"+invalidProducts+
                     "were invalid",savedUserProduct));


     }
       else return ResponseEntity.status(HttpStatus.NOT_FOUND).body( new ResponseDTO(HttpStatus.NOT_FOUND,"user not found",""));


    }
}



/*
datasource
feign client
keycloak
swagger
crossOrigin
 */
