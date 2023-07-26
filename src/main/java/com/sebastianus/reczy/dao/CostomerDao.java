package com.sebastianus.reczy.dao;

import com.sebastianus.reczy.entity.Costomer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CostomerDao extends CrudRepository<Costomer, String> {

    Optional<Costomer> findCostomerById(String id);
}
