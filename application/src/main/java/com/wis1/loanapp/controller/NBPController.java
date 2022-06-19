package com.wis1.loanapp.controller;

import com.wis1.loanapp.calc.client.NbpClient;
import com.wis1.loanapp.dto.ExchangeRateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/nbp")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NBPController {

    private final NbpClient nbpClient;

    @GetMapping("/dollars")
    public void getDollarsRate(){
        ExchangeRateDto exchangeRateDto=nbpClient.getExchangeRateOf();
        System.out.println(exchangeRateDto.getRatesMid());
    }


    @GetMapping("/euro")
    public void getEuroRate(){

    }

    @GetMapping("/frank")
    public void getFrankRate(){

    }



}
