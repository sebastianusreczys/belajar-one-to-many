package com.sebastianus.reczy.dao;

import com.sebastianus.reczy.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, String > {

}
