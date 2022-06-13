package com.wis1.loanapp.controller;

import com.wis1.loanapp.calc.client.CalcClient;
import com.wis1.loanapp.dto.CalcResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("v1/calcApi")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CalcApiController {

    private final CalcClient calcClient;

    @GetMapping
    public void getCalcResult(){

        Optional<CalcResultDto> calcResultDto= calcClient.getCalcResult();
        System.out.println(calcResultDto.toString());
    }
}
