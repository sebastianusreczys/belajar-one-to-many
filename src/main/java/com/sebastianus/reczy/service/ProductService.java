package com.sebastianus.reczy.service;

import com.sebastianus.reczy.dao.ProductDao;
import com.sebastianus.reczy.dto.ProductDto;
import com.sebastianus.reczy.dto.ProductResponse;
import com.sebastianus.reczy.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public ProductResponse add(ProductDto productDto){
        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setKode(productDto.getKode());
        product.setNama(productDto.getNama());
        product.setHarga(productDto.getHarga());
        productDao.save(product);
        return toProductResponse(product);
    }

    private ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .nama(product.getNama())
                .kode(product.getKode())
                .harga(product.getHarga()).build();
    }
}
