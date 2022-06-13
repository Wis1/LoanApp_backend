package com.wis1.loanapp.calc.client;

import com.wis1.loanapp.dto.CalcResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CalcClient {

    private final RestTemplate restTemplate;

    @Value("${calc.api.endpoint.prod}")
    private String calApiEndpoint;

    public Optional<CalcResultDto> getCalcResult() {
        URI url= UriComponentsBuilder.fromHttpUrl(calApiEndpoint)
                .queryParam("amount", 1000 )
                .queryParam("installments", 24)
                .queryParam("interest_rate", 8)
                .queryParam("diminishing", false)
                .queryParam("X-RapidAPI-Key", "c1f33630aamshd9c68a8ef87c1f5p188968jsn86ae09702ab9")
                .queryParam("X-RapidAPI-Host", "loan-generator1.p.rapidapi.com")
                .build().encode().toUri();

        CalcResultDto calcResult= restTemplate.getForObject(url,CalcResultDto.class);

        return Optional.ofNullable(calcResult);


    }
}
