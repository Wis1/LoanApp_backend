package com.wis1.loanapp.controller;

import com.wis1.loanapp.calc.client.NbpClient;
import com.wis1.loanapp.dto.ExchangeRateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/nbp")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NBPController {

    private final NbpClient nbpClient;

    @GetMapping("{usd}")
    public void getDollarsRate(@PathVariable String usd){
        ExchangeRateDto exchangeRateDto=nbpClient.getExchangeRateOf(usd);
        System.out.println(exchangeRateDto.getRatesMid());
    }


    @GetMapping("{eur}")
    public void getEuroRate(@PathVariable String eur){

        ExchangeRateDto exchangeRateDto=nbpClient.getExchangeRateOf(eur);
        System.out.println(exchangeRateDto);

    }

    @GetMapping("{chf}")
    public void getFrankRate(@PathVariable String chf ){

        ExchangeRateDto exchangeRateDto= nbpClient.getExchangeRateOf(chf);
        System.out.println(exchangeRateDto);

    }



}
