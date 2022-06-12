package com.wis1.loanapp.service;

import com.wis1.loanapp.domain.Client;
import com.wis1.loanapp.exception.ClientNotFoundException;
import com.wis1.loanapp.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientDbService {

    private final ClientRepository clientRepository;

    public List<Client> getAllClients() { return clientRepository.findAll();}

    public Client getClientWithId(final Long id) throws ClientNotFoundException {
       return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    public void deleteClient(final Long id) {
        clientRepository.deleteById(id);
    }

    public void deleteAll(){
        clientRepository.deleteAll();
    }

    public Client saveClient(final Client client){
        return clientRepository.save(client);
    }
}
