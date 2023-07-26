package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid")

    @Column(length = 36, name = "productId")
    private String id;

    @Column(length = 100, nullable = false)
    private String kode;

    @Column(length = 100, nullable = false)
    private String nama;

    private BigDecimal harga;
}
