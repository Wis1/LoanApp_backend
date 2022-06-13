package com.wis1.loanapp.mapper;

import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.dto.CalculateDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculateMapper {

    public Calculate mapToCalculate(final CalculateDto calculateDto) {
        return new Calculate(
                calculateDto.getId(),
                calculateDto.getAmountLoan(),
                calculateDto.getLoanLenght()
        );
    }

    public CalculateDto mapToCalculateDto(final Calculate calculate) {
        return new CalculateDto(
                calculate.getId(),
                calculate.getAmountLoan(),
                calculate.getLoanLength()
        );
    }

    public List<CalculateDto> mapToCalculateDtoList(final List<Calculate> calculateList) {
        return calculateList.stream()
                .map(this::mapToCalculateDto)
                .collect(Collectors.toList());
    }
}
