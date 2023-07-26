package com.sebastianus.reczy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "order_details")
@Data
@Slf4j
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid")
    private String id;

    @ManyToOne
    @JoinColumn(name = "orderId")
    @JsonIgnore
    @NotNull
    private Order order;

    @ManyToOne
    @JoinColumn(name = "productId")
    @NotNull
    private Product product;

    private Integer jumlah;

    private BigDecimal totalHarga;


}
