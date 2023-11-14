package com.example.Product_collabaration.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDTO {

    private Long userId;

    private Map<Long,Long> productIdWithQuantity;
}
