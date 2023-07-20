package com.wis1.loanapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

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


@Getter
@Setter
class ScheduleItem {
    private String balance;
    private String interest;
    private String payment;
    private int period;
    private String principal;

}
