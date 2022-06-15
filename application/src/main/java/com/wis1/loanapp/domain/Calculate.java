package com.wis1.loanapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "calculate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Calculate {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer amountLoan;

    @Column
    private Integer loanLength;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Calculate(Long id, Integer amountLoan, Integer loanLength) {
        this.id = id;
        this.amountLoan = amountLoan;
        this.loanLength = loanLength;
    }
}
