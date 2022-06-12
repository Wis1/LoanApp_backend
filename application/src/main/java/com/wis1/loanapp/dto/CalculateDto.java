package com.wis1.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CalculateDto {

    private Long id;
    private Integer totalCostLoan;
    private Integer installments;

}
