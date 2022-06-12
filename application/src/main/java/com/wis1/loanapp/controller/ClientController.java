package com.wis1.loanapp.controller;

import com.wis1.loanapp.dto.ClientDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/client")
@RequiredArgsConstructor
public class ClientController {

    @GetMapping
    public void getClient(){

    }

    @GetMapping
    public void getWhatLoanWant(){

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addClient(){

    }

    @PutMapping
    public void updateClient(@RequestBody ClientDto clientDto){

    }

    @DeleteMapping(path = "{clientId}")
    public void deleteClient(@PathVariable Long clientId){

    }
}
