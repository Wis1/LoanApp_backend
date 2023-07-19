package com.wis1.loanapp.controller;

import com.google.gson.Gson;
import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.domain.Client;
import com.wis1.loanapp.dto.CalculateDto;
import com.wis1.loanapp.mapper.CalculateMapper;
import com.wis1.loanapp.service.CalculateDbService;
import com.wis1.loanapp.service.ClientDbService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringJUnitWebConfig
@WebMvcTest(CalculateController.class)
public class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculateDbService calculateDbService;

    @MockBean
    private CalculateMapper calculateMapper;

    @MockBean
    private ClientDbService clientDbService;

    @Test
    void shouldGetCalculates() throws Exception {

        //Given
        List<Calculate> calculateList= List.of(new Calculate(2L, 20000, 48, ""));
        List<CalculateDto> calculateDtoList= List.of(new CalculateDto(2L,20000,48, ""));
        when(calculateDbService.getAllCalculate()).thenReturn(calculateList);
        when(calculateMapper.mapToCalculateDtoList(calculateList)).thenReturn(calculateDtoList);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/calculate")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].id", Matchers.is(2)))
                .andExpect(jsonPath("$[0].amountLoan", Matchers.is(20000)))
                .andExpect(jsonPath("$[0].loanLength", Matchers.is(48)));
    }

    @Test
    void shouldGetCalculateWithId() throws Exception {

        //Given
        CalculateDto calculateDto= new CalculateDto(3L, 40000, 60, "");
        Calculate calculate= new Calculate(3L, 40000, 60, "");


        when(calculateMapper.mapToCalculateDto(calculate)).thenReturn(calculateDto);
        when(calculateDbService.getCalculateById(3L)).thenReturn(calculate);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .get("/v1/calculate/onecalculate/{id}", 3L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$.id", Matchers.is(3)))
                .andExpect(jsonPath("$.amountLoan", Matchers.is(40000)))
                .andExpect(jsonPath("$.loanLength", Matchers.is(60)));

    }

    @Test
    void shouldCreateCalculate() throws Exception {

        //Given
        CalculateDto newCalculateDto= new CalculateDto(4L, 78000, 78, "");
        Calculate newCalculate= new Calculate(4L, 78000, 78, "");
        Client client= new Client(7L,"Paul", "Test");


        when(calculateMapper.mapToCalculate(any(CalculateDto.class))).thenReturn(newCalculate);
        when(clientDbService.getClientWithId(7L)).thenReturn(client);
        when(calculateDbService.saveCalculate(any(Calculate.class))).thenReturn(newCalculate);

        Gson gson= new Gson();
        String jsonContent= gson.toJson(newCalculateDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/v1/calculate/{clientId}", 7L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldDeleteCalculate() throws Exception {

        //Given
        CalculateDto calculateDto= new CalculateDto(5L, 56000,34, "");
        Calculate calculate= new Calculate(5L, 56000,34, "");

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .delete("/v1/calculate/{calculateId}", 5L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldUpdateCalculate() throws Exception {

        //Given
        CalculateDto calculateDto= new CalculateDto(7L, 47000,24, "");
        Calculate calculate= new Calculate(7L, 47000, 24, "");
        Calculate updateCalculate= new Calculate(8L, 100000, 240, "");
        CalculateDto updateCalculateDto= new CalculateDto(8L,100000, 240, "");

        when(calculateMapper.mapToCalculate(any(CalculateDto.class))).thenReturn(calculate);
        when(calculateDbService.saveCalculate(any(Calculate.class))).thenReturn(updateCalculate);
        when(calculateMapper.mapToCalculateDto(any(Calculate.class))).thenReturn(updateCalculateDto);

        Gson gson= new Gson();
        String jsonContent= gson.toJson(calculateDto);

        //When & Then
        mockMvc
                .perform(MockMvcRequestBuilders
                        .put("/v1/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding("UTF-8")
                        .content(jsonContent))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(8)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amountLoan", Matchers.is(100000)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.loanLength", Matchers.is(240)));
    }
}
