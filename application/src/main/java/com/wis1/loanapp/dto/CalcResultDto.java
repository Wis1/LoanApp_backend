package com.wis1.loanapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CalcResultDto {

    @JsonProperty("monthly_payment")
    private Object amount;

    @JsonProperty("schedule")
    private List<Object> details;

    @Override
    public String toString() {
        return "amount=" + amount.toString() +
                ", details=" + details.toString();
    }
}
