package com.geekbrains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalObjectDto {
    private Long id;
    private String title;
    private BigDecimal pricePerNight;
    private Boolean isFree;

}
