package com.platzipizzeria.service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdatePizzaPriceDto {
    private int pizzaId;
    private BigDecimal newPrice;
}
