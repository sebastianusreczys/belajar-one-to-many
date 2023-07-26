package com.sebastianus.reczy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CostomerResponse {
    private String id;
    private String name;
    private String email;
}
