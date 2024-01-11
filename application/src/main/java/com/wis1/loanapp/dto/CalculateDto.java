package com.wis1.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculateDto {

    private Long id;
    private Integer amountLoan;
    private Integer loanLength;
    private CalcResultDto calculate;
}
