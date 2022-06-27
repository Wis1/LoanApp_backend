package com.wis1.loanapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalcResultDto {

    @JsonProperty("amount")
    private Object amount;

    @JsonProperty("details")
    private Object details;
}
