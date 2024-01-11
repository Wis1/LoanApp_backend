package com.wis1.loanapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "schedule_item")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public
class ScheduleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @ManyToOne()
    private CalcResult calcResult;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleItem that = (ScheduleItem) o;
        return Objects.equals(id, that.id) && Objects.equals(calcResult, that.calcResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, calcResult);
    }

    public ScheduleItem(String balance, String interest, String payment, String principal, int period) {
        this.balance= balance;
        this.interest= interest;
        this.payment= payment;
        this.principal= principal;
        this.period= period;
    }
}