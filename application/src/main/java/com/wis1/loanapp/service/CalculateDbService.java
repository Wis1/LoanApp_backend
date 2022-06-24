package com.wis1.loanapp.service;

import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.domain.Client;
import com.wis1.loanapp.exception.CalculateNotFoundException;
import com.wis1.loanapp.repository.CalculateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateDbService {

    private final CalculateRepository calculateRepository;

    public Calculate getCalculateById(final Long id) throws CalculateNotFoundException {
        return calculateRepository.findById(id).orElseThrow(CalculateNotFoundException::new);
    }

    public List<Calculate> getAllCalculate(){
        return calculateRepository.findAll();
    }

    public List<Calculate> getAllCalculateByClient(final Client client) {

        return calculateRepository.findByClient(client);
    }

    public void deleteCalculate(final Long id){
        calculateRepository.deleteById(id);
    }

    public Calculate saveCalculate(final Calculate calculate) {
        return calculateRepository.save(calculate);
    }

}
