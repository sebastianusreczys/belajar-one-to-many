package com.sebastianus.reczy.dto;

import com.sebastianus.reczy.entity.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto {
    private String costomerId;
    private List<OrderDetail> orderDetailDtoList;
}
