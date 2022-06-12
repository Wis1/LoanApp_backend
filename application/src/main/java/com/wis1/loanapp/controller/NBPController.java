package com.wis1.loanapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/nbp")
@RequiredArgsConstructor
public class NBPController {

    @GetMapping("/dollars")
    public void getDollarsRate(){

    }


    @GetMapping("/euro")
    public void getEuroRate(){

    }

    @GetMapping("/frank")
    public void getFrankRate(){

    }



}
