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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer amountLoan;

    @Column
    private Integer loanLength;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "calcresult_id", referencedColumnName = "id")
    private CalcResult calcResult;

    public Calculate(Integer amountLoan, Integer loanLength, CalcResult calcResult) {
        this.amountLoan = amountLoan;
        this.loanLength = loanLength;
        this.calcResult = calcResult;
    }
}
