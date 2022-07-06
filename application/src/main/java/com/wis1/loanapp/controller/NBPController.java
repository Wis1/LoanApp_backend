package com.wis1.loanapp.controller;

import com.wis1.loanapp.calc.client.NbpClient;
import com.wis1.loanapp.dto.ExchangeRateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/nbp/")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NBPController {

    private final NbpClient nbpClient;

    @GetMapping("/usd/{usd}")
    public ResponseEntity<ExchangeRateDto> getDollarsRate(@PathVariable String usd){
        ExchangeRateDto exchangeRateDto=nbpClient.getExchangeRateOf(usd);
        return ResponseEntity.ok(exchangeRateDto);
    }


    @GetMapping("/eur/{eur}")
    public ResponseEntity<ExchangeRateDto> getEuroRate(@PathVariable String eur){

        ExchangeRateDto exchangeRateDto=nbpClient.getExchangeRateOf(eur);
        return ResponseEntity.ok(exchangeRateDto);

    }

    @GetMapping("/chf/{chf}")
    public ResponseEntity<ExchangeRateDto> getFrankRate(@PathVariable String chf ){

        ExchangeRateDto exchangeRateDto= nbpClient.getExchangeRateOf(chf);
        return ResponseEntity.ok(exchangeRateDto);

    }

    @GetMapping("/information")
    public ResponseEntity<String> getInformationAboutMainExchangeRates() {
        String information= "Euro: " + nbpClient.getExchangeRateOf("eur").getRatesMid()+"\n"+
                "USD: "+ nbpClient.getExchangeRateOf("usd").getRatesMid()+"\n"+
                "CHF: "+ nbpClient.getExchangeRateOf("chf").getRatesMid();
        return ResponseEntity.ok(information);
    }



}
