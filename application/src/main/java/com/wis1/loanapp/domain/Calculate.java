package com.wis1.loanapp.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "calculate")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Calculate {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Integer amountLoan;

    @Column
    private Integer loanLength;


}
