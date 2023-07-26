package com.sebastianus.reczy.service;

import com.sebastianus.reczy.dao.CostomerDao;
import com.sebastianus.reczy.dto.CostomerDto;
import com.sebastianus.reczy.dto.CostomerResponse;
import com.sebastianus.reczy.entity.Costomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CostomerService {

    @Autowired
    private CostomerDao costomerDao;

    public CostomerResponse add(CostomerDto costomerDto){
        Costomer costomer = new Costomer();
        costomer.setId(UUID.randomUUID().toString());
        costomer.setName(costomerDto.getName());
        costomer.setEmail(costomerDto.getEmail());
        costomerDao.save(costomer);
        return costomerResponse(costomer);
    }

    private CostomerResponse costomerResponse(Costomer costomer){
        return CostomerResponse.builder()
                .id(costomer.getId())
                .name(costomer.getName())
                .email(costomer.getEmail()).build();
    }



}
