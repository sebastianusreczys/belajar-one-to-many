package com.sebastianus.reczy.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name = "uuid")
    private String id;

    private Timestamp waktu_transaksi;

    @ManyToOne
    @JoinColumn(name = "costomerId")
    private Costomer costomer;

    @OneToMany(
            cascade = CascadeType.ALL,
                    orphanRemoval = true,
                    mappedBy = "order")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    public void addOrderDetail(OrderDetail orderDetail){
//        BigDecimal total = orderDetail.getProduct().getHarga().add(new BigDecimal(orderDetail.getJumlah()));
//        orderDetail.setTotalHarga(total);
        orderDetailList.add(orderDetail);
        orderDetail.setOrder(this);
    }

}
