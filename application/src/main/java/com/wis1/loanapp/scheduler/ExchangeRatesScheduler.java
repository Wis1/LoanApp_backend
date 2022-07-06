package com.wis1.loanapp.scheduler;

import com.wis1.loanapp.calc.client.NbpClient;
import com.wis1.loanapp.controller.NBPController;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeRatesScheduler {
    private final NbpClient nbpClient;
    private final NBPController controller;

    @Scheduled(fixedDelay = 100000)
    public void getExchangeRates(){

        controller.getInformationAboutMainExchangeRates();
        System.out.println("Actual exchange rates of eur is: "+ nbpClient.getExchangeRateOf("eur").getRatesMid());
        System.out.println("Actual exchange rates of usd is: "+ nbpClient.getExchangeRateOf("usd").getRatesMid());
        System.out.println("Actual exchange rates of chf is: "+ nbpClient.getExchangeRateOf("chf").getRatesMid());

    }
}
