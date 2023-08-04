package com.wis1.loanapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "calc_result")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CalcResult {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String interest_rate;

    @Column
    private String loan_amount;

    @Column
    private String loan_interest;

    @Column
    private String loan_type;

    @Column
    private String monthly_payment;

    @Column
    private String repayment_term;

    @OneToMany(targetEntity = ScheduleItem.class,
            mappedBy = "calcResult",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<com.wis1.loanapp.domain.ScheduleItem> schedule = new ArrayList<>();

    @OneToOne
    private Calculate calculate;

    public CalcResult(String interest_rate,
                      String loan_amount,
                      String loan_interest,
                      String loan_type,
                      String monthly_payment,
                      String repayment_term,
                      List<ScheduleItem> schedule) {
        this.interest_rate = interest_rate;
        this.loan_amount = loan_amount;
        this.loan_interest = loan_interest;
        this.loan_type = loan_type;
        this.monthly_payment = monthly_payment;
        this.repayment_term = repayment_term;
        this.schedule = schedule;
    }
}



