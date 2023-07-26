package com.sebastianus.reczy.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDto {
    private String id;

    @Size(min = 3, max = 100)
    private String kode;

    @Size(min = 3, max = 100)
    private String nama;

    private BigDecimal harga;
}
