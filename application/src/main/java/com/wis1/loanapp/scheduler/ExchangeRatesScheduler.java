package com.wis1.loanapp.scheduler;

import com.wis1.loanapp.controller.NBPController;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeRatesScheduler {
    private final NBPController controller;

    @Scheduled(fixedDelay = 100000)
    public void getExchangeRates(){
        String message= "Actual exchange rates of: ";
        System.out.println(message + "\n" +  controller.getInformationAboutMainExchangeRates().getBody());
    }
}
