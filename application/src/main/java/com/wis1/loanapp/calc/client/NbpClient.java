package com.wis1.loanapp.calc.client;

import com.wis1.loanapp.dto.ExchangeRateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@Component
@RequiredArgsConstructor
public class NbpClient {

    private final RestTemplate restTemplate;

    @Value("${nbp.api.endpoint.prod}")
    private String nbpEndpoint;

    public ExchangeRateDto getExchangeRateOf() {

        URI url= UriComponentsBuilder.fromHttpUrl(nbpEndpoint)
                .path("/c/eur/2022-06-15")
                .build().encode().toUri();
        ExchangeRateDto response= restTemplate.getForObject(url, ExchangeRateDto.class);

        return response;

    }

}
