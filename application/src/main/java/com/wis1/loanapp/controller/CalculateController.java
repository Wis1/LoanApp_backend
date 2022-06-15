package com.wis1.loanapp.controller;

import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.domain.Client;
import com.wis1.loanapp.dto.CalculateDto;
import com.wis1.loanapp.exception.ClientNotFoundException;
import com.wis1.loanapp.mapper.CalculateMapper;
import com.wis1.loanapp.service.CalculateDbService;
import com.wis1.loanapp.service.ClientDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/calculate")
@RequiredArgsConstructor
public class CalculateController {

    private final CalculateDbService calculateDbService;
    private final CalculateMapper calculateMapper;
    private final ClientDbService clientDbService;

    @GetMapping(value = "{id}")
    public List<CalculateDto>  getCalculateLoan(@PathVariable Long id) throws ClientNotFoundException {
        Client client= clientDbService.getClientWithId(id);
        List<Calculate> calculateList= calculateDbService.getAllCalculateByClient(client);
        return calculateMapper.mapToCalculateDtoList(calculateList);
    }



    @GetMapping("totalCost")
    public void totalCostOfTheLoan(){

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "{clientId}")
    public void addNewCalculate(@RequestBody CalculateDto calculateDto, @PathVariable Long clientId) throws ClientNotFoundException {


        Calculate calculate=calculateMapper.mapToCalculate(calculateDto);
        calculate.setClient(clientDbService.getClientWithId(clientId));
        calculateDbService.saveCalculate(calculate);
    }


}
