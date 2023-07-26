package com.sebastianus.reczy.controller;

import com.sebastianus.reczy.dto.CostomerDto;
import com.sebastianus.reczy.dto.CostomerResponse;
import com.sebastianus.reczy.dto.WebResponse;
import com.sebastianus.reczy.entity.Costomer;
import com.sebastianus.reczy.service.CostomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostomerApiController {

    @Autowired
    private CostomerService costomerService;

    @PostMapping(
            path = "/api/costomers",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<CostomerResponse> add(@RequestBody CostomerDto costomerDto){
        return WebResponse.<CostomerResponse>builder().data(costomerService.add(costomerDto)).build();
    }
}
