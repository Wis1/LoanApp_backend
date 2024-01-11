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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "calcResult"
    )
    private Calculate calculate;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "calcResult",
            orphanRemoval = true)
    private List<ScheduleItem> schedule = new ArrayList<>();

    public void addScheduleItem(ScheduleItem scheduleItem) {
        this.schedule.add(scheduleItem);
        scheduleItem.setCalcResult(this);
    }

    public void removeScheduleItem(ScheduleItem scheduleItem) {
        schedule.remove(scheduleItem);
        scheduleItem.setCalcResult(null);
    }

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



