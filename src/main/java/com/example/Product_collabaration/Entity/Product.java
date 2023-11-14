package com.example.Product_collabaration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "sellerId")
    private Long sellerId;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "productType")
    private String productType;

    @Column(name ="productName" )
    private String productName;

}
