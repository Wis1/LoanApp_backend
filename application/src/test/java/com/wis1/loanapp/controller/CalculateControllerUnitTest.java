package com.wis1.loanapp.controller;

import com.wis1.loanapp.dto.CalculateDto;
import com.wis1.loanapp.dto.ClientDto;
import com.wis1.loanapp.exception.ClientNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class CalculateControllerUnitTest {
//
//    @Autowired
//    private CalculateController calculateController;
//
//    @Autowired
//    private ClientController clientController;
//
//
//
//    @Test
//    void getCalculate() throws ClientNotFoundException {
//
//        //Given
//        CalculateDto calculateDto= new CalculateDto(1L, 50000, 100);
//        List<CalculateDto> calculateDtoList= new ArrayList<>();
//        calculateDtoList.add(calculateDto);
//        ClientDto clientDto= new ClientDto(8L, "Test", "Tester");
//
//        //When
//        clientController.addClient(clientDto);
//        calculateController.addNewCalculate(calculateDto, 8L);
//
//        //Then
//        assertEquals(ResponseEntity.ok(calculateDtoList).getBody().get(0).getAmountLoan(),calculateController.getCalculate().getBody().stream().filter(c->c.getId().equals(1L)).findFirst().get().getAmountLoan());
//    }
//}
