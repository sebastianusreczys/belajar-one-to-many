package com.sebastianus.reczy.service;

import com.google.gson.Gson;
import com.sebastianus.reczy.dao.CostomerDao;
import com.sebastianus.reczy.dao.OrderDao;
import com.sebastianus.reczy.dao.ProductDao;
import com.sebastianus.reczy.dto.OrderDto;
import com.sebastianus.reczy.dto.OrderResponse;
import com.sebastianus.reczy.entity.Costomer;
import com.sebastianus.reczy.entity.Order;
import com.sebastianus.reczy.entity.OrderDetail;
import com.sebastianus.reczy.entity.Product;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Log4j2
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CostomerDao costomerDao;

    public Order addOrder(OrderDto orderDto){

        Costomer costomer = costomerDao.findCostomerById(orderDto.getCostomerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Costomer Not Found"));
        Order order = new Order();
        order.setId(UUID.randomUUID().toString());
        order.setWaktu_transaksi(new Timestamp(new Date().getTime()));
        order.setCostomer(costomer);
        for (OrderDetail orderDetail: orderDto.getOrderDetailDtoList()){
//            BigDecimal total = orderDetail.getProduct().getHarga().add(new BigDecimal(orderDetail.getJumlah()));
//            orderDetail.setTotalHarga(total);
//            order.addOrderDetail(orderDetail);
//            log.info("Order Details :{}", orderDetail.getId());
            Product product = orderDetail.getProduct();
            if (product == null) {
                // Handle the case when the product is null (e.g., throw an exception or skip this order detail).
                // For example:
                throw new IllegalArgumentException("Product in order detail is null.");
            }

            BigDecimal harga = product.getHarga();
            if (harga == null) {
                // Handle the case when harga is null (e.g., throw an exception or set a default value).
                // For example:
                throw new IllegalArgumentException("Harga for product " + product.getId() + " is null.");
            }
            BigDecimal total = BigDecimal.ZERO;
            total = total.add(product.getHarga().multiply(new BigDecimal(orderDetail.getJumlah())));
            orderDetail.setTotalHarga(total);
            order.addOrderDetail(orderDetail);
        }
       return orderDao.save(order);
    }
    private OrderResponse toOrderResponse(Order order){
        return OrderResponse.builder()
                .waktu_order(order.getWaktu_transaksi())
                .orderDetailList(order.getOrderDetailList()).build();
    }
}
