package com.wis1.loanapp.controller;

import com.wis1.loanapp.domain.Client;
import com.wis1.loanapp.dto.ClientDto;
import com.wis1.loanapp.mapper.ClientMapper;
import com.wis1.loanapp.service.ClientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientDbService clientDbService;
    private final ClientMapper clientMapper;

    @GetMapping
    public List<ClientDto> getAllClients(){

        List<Client> clientDtoList= clientDbService.getAllClients();
        return clientMapper.mapToClientDtoList(clientDtoList);

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addClient(@RequestBody ClientDto clientDto){

        clientDbService.saveClient(clientMapper.mapToClient(clientDto));

    }

    @PutMapping
    public ClientDto updateClient(@RequestBody ClientDto clientDto){

        Client updateClient= clientDbService.saveClient(clientMapper.mapToClient(clientDto));
        return clientMapper.mapToClientDto(updateClient);

    }

    @DeleteMapping(path = "{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        clientDbService.deleteClient(clientId);
    }
}
