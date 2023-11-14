package com.example.Product_collabaration.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Table(name = "UserProduct")
public class UserProduct
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(referencedColumnName = "productId",name = "productId")
    @ManyToOne(targetEntity = Product.class,cascade = CascadeType.ALL)
    private Product productId;

    @ManyToOne(targetEntity = Transaction.class,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName ="transactionId",name="transactionId" )
    private Transaction  transactionId;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "amount")
    private Long amount;

}
