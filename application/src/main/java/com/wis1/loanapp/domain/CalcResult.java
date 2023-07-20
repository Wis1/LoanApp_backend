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
    private List<com.wis1.loanapp.domain.ScheduleItem> schedule= new ArrayList<>();

    @OneToOne
    private Calculate calculate;

}

@Entity(name = "schedule_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class ScheduleItem {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String balance;

    @Column
    private String interest;

    @Column
    private String payment;

    @Column
    private int period;

    @Column
    private String principal;

    @ManyToOne
    @JoinColumn(name = "CALCRESULT_ID")
    private CalcResult calcResult;

}

