package com.wis1.loanapp.mapper;

import com.wis1.loanapp.domain.Client;
import com.wis1.loanapp.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientMapper {

    public Client mapToClient(final ClientDto clientDto) {
        return new Client(
                clientDto.getId(),
                clientDto.getAmountLoan(),
                clientDto.getAmountLoan()
        );
    }

    public ClientDto mapToClientDto(final Optional<Client> client){
        return new ClientDto(
                client.get().getId(),
                client.get().getAmountLoan(),
                client.get().getLoanLength()
        );
    }

    public ClientDto mapToClientDto(final Client client){
        return new ClientDto(
                client.getId(),
                client.getAmountLoan(),
                client.getLoanLength()
        );
    }

    public List<ClientDto> mapToClientDtoList(final List<Client> clientList){
        return clientList.stream()
                .map(this::mapToClientDto)
                .collect(Collectors.toList());
    }
}
