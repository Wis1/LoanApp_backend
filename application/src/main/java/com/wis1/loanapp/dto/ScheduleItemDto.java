package com.wis1.loanapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScheduleItemDto {

    private Long id;
    private String balance;
    private String interest;
    private String payment;
    private int period;
    private String principal;
}
