package com.wis1.loanapp.calc.client;

import com.google.gson.Gson;
import com.wis1.loanapp.dto.CalcResultDto;
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

    @Value("${X-RapidAPI-Key}")
    private String rapidApiKey;

    @Value("${X-RapidAPI-Host}")
    private String rapidApiHost;

    public String getCalcResult(Integer amount, Integer installments) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(UriComponentsBuilder.fromHttpUrl(calApiEndpoint)
                        .queryParam("loan", amount)
                        .queryParam("rate", 8)
                        .queryParam("term", installments)
                        .queryParam("currency", "USD").build().encode().toString()))
                .header("X-RapidAPI-Key", rapidApiKey)
                .header("X-RapidAPI-Host", rapidApiHost)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
