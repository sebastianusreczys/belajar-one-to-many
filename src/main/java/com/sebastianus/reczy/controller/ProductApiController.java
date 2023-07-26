package com.sebastianus.reczy.controller;

import com.sebastianus.reczy.dto.CostomerDto;
import com.sebastianus.reczy.dto.ProductDto;
import com.sebastianus.reczy.dto.ProductResponse;
import com.sebastianus.reczy.dto.WebResponse;
import com.sebastianus.reczy.entity.Product;
import com.sebastianus.reczy.service.CostomerService;
import com.sebastianus.reczy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductApiController {

    @Autowired
    private ProductService productService;

    @PostMapping(
            path = "/api/products",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<ProductResponse> add(@RequestBody ProductDto productDto){
        return WebResponse.<ProductResponse>builder().data(productService.add(productDto)).build();
    }
}
