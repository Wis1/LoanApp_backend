package com.wis1.loanapp.controller;

import com.wis1.loanapp.calc.client.CalcClient;
import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.exception.CalculateNotFoundException;
import com.wis1.loanapp.service.CalculateDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("v1/calcApi")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CalcApiController {

    private final CalcClient calcClient;
    private final CalculateDbService calculateDbService;

    @GetMapping(value = "{calculateId}")
    public void getCalcResultToCalculate(@PathVariable Long calculateId) throws IOException, InterruptedException, CalculateNotFoundException {
        Calculate calculate= calculateDbService.getCalculateById(calculateId);
        Integer amount= calculate.getAmountLoan();
        Integer installments= calculate.getLoanLength();

        String calcResultDtoList= calcClient.getCalcResult(amount, installments);
        System.out.println(calcResultDtoList);
    }
}
