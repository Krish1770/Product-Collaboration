package com.example.Product_collabaration.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor@NoArgsConstructor
public class ProductUpdateDTO {

    private String productName;

    private String productType;

    private String amount;
}
