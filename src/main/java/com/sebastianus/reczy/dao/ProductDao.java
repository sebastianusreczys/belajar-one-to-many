package com.sebastianus.reczy.dao;

import com.sebastianus.reczy.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, String> {
}
