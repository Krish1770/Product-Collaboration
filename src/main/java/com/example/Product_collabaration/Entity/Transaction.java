package com.example.Product_collabaration.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Column(name = "userId")
    private Long userId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

}
