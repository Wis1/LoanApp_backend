package com.wis1.loanapp.calc.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@RequiredArgsConstructor
public class CalcClient {

    private final RestTemplate restTemplate;

    @Value("${calc.api.endpoint.prod}")
    private String calApiEndpoint;

    public String getCalcResult(Integer amount, Integer installments) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(UriComponentsBuilder.fromHttpUrl(calApiEndpoint)
                        .queryParam("amount", amount)
                        .queryParam("installments", installments)
                        .queryParam("interest_rate", 8)
                        .queryParam("diminishing", false).build().encode().toString()))
                .header("X-RapidAPI-Key", "a5031c4912mshe2b2222390a030ap13bb3cjsn29ea85b82148")
                .header("X-RapidAPI-Host", "loan-generator1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}
