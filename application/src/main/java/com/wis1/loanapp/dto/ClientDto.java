package com.wis1.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientDto {

    private Long id;
    private Integer amountLoan;
    private Integer loanLength;
}
