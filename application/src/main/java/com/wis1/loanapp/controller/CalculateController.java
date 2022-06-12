package com.wis1.loanapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/calculate")
@RequiredArgsConstructor
public class CalculateController {

    @GetMapping
    public void getCalculateLoan(){


    }

    @GetMapping(path = "{numberOfMonths}")
    public void getInstallmentForMonths(@PathVariable Integer numberOfMonths){

    }

    @GetMapping("totalCost")
    public void totalCostOfTheLoan(){

    }

    @PostMapping
    public void addNewCalculate(@PathVariable Integer amountLoan, @PathVariable Integer numberOfMonths){

    }


}
