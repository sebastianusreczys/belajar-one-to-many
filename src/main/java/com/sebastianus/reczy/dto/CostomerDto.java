package com.sebastianus.reczy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CostomerDto {
    private String id;
    private String name;
    private String email;
}
