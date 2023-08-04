package com.wis1.loanapp.dto;

import com.wis1.loanapp.domain.ScheduleItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalcResultDto {
    private String interest_rate;
    private String loan_amount;
    private String loan_interest;
    private String loan_type;
    private String monthly_payment;
    private String repayment_term;
    private List<ScheduleItem> schedule;
}
