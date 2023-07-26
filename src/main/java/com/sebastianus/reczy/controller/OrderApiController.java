package com.sebastianus.reczy.controller;

import com.google.gson.Gson;
import com.sebastianus.reczy.dto.CostomerResponse;
import com.sebastianus.reczy.dto.OrderDto;
import com.sebastianus.reczy.dto.OrderResponse;
import com.sebastianus.reczy.dto.WebResponse;
import com.sebastianus.reczy.entity.Order;
import com.sebastianus.reczy.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class OrderApiController {

    @Autowired
    private OrderService orderService;

    @PostMapping(
            path = "/api/orders",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<Order> addOrder(@RequestBody OrderDto orderDto){

        Gson gson = new Gson();
        String json = gson.toJson(orderDto);
        log.info("json :{}", json);


        return WebResponse.<Order>builder().data(orderService.addOrder(orderDto)).build();
    }

}
