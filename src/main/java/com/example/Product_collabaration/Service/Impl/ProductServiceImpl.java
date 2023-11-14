package com.example.Product_collabaration.Service.Impl;

import com.example.Product_collabaration.DTO.ProductUpdateDTO;
import com.example.Product_collabaration.DTO.ResponseDTO;
import com.example.Product_collabaration.Entity.Product;
import com.example.Product_collabaration.Entity.Transaction;
import com.example.Product_collabaration.Repository.Service.ProductRepoService;
import com.example.Product_collabaration.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
   private  ModelMapper modelMapper;
    @Autowired
    private ProductRepoService productRepoService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ResponseEntity<ResponseDTO> addProducts(Product product) {

        Long userId=product.getSellerId();
        String url = "http://localhost:8081/User/get/"+userId;
        ResponseDTO responseDTO = restTemplate.getForObject(url, ResponseDTO.class);
        System.out.println(responseDTO);

        if(responseDTO.getMessage().equals("user not found"))
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"invalid sellerId",""));


//        Product newProduct=productRepoService.save(product);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"product added",""));
    }

    @Override
    public ResponseEntity<ResponseDTO> updateProducts(Long productId,ProductUpdateDTO productUpdateDTO)
    {
      Optional<Product> product=productRepoService.findById(productId);

      if(product.isPresent())
      {
          Product temp=modelMapper.map(productUpdateDTO,Product.class);
          temp.setProductId(productId);
          productRepoService.save(temp);
          return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"product updated",temp));
      }
return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(HttpStatus.NOT_FOUND,"product not found",""));
    }

    @Override
    public ResponseEntity<ResponseDTO> getCollaborators(Long productId) {

        if(ifProductExist(productId))
        {
            List<Product> collaborators=new ArrayList<>();

    String url="http://localhost:8082/Message/getCollaborators/"+productId;
    ResponseDTO responseDTO=restTemplate.getForObject(url, ResponseDTO.class);

            assert responseDTO != null;

          List<Long> arrayList=modelMapper.map(responseDTO.getData(),List.class);

            System.out.println(arrayList.toString());

            for(int i=0;i<arrayList.size();i++)
            {
                collaborators.add(productRepoService.findById(Long.parseLong(String.valueOf(arrayList.get(i)))).get());
            }
//            for(Long i:arrayList)
//             collaborators.add(productRepoService.findById(i).get());
            System.out.println(collaborators);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK,"collaborator list",collaborators));




        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseDTO(HttpStatus.NOT_FOUND,"product not found",""));
    }

    public boolean ifProductExist(Long productId)
    {
        return productRepoService.findById(productId).isPresent();
    }
}

