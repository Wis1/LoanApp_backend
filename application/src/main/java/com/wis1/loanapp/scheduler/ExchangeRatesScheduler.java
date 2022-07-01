package com.wis1.loanapp.scheduler;

import com.wis1.loanapp.calc.client.NbpClient;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeRatesScheduler {
    private final NbpClient nbpClient;

    @Scheduled(fixedDelay = 10000)
    public void getExchangeRates(){
        System.out.println("Actual exchange rates of eur is: "+ nbpClient.getExchangeRateOf("eur").getRatesMid());
        System.out.println("Actual exchange rates of usd is: "+ nbpClient.getExchangeRateOf("usd").getRatesMid());
        System.out.println("Actual exchange rates of chf is: "+ nbpClient.getExchangeRateOf("chf").getRatesMid());
    }
}
