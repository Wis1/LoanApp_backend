package com.wis1.loanapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "schedule_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public
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

    public ScheduleItem(String balance, String interest, String payment, String principal, int period) {
    }
}