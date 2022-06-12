package com.wis1.loanapp.mapper;

import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.dto.CalculateDto;
import org.springframework.stereotype.Service;

@Service
public class CalculateMapper {

    public Calculate mapToCalculate(final CalculateDto calculateDto) {
        return new Calculate(
                calculateDto.getId(),
                calculateDto.getTotalCostLoan(),
                calculateDto.getInstallments()
        );
    }

    public CalculateDto mapToCalculateDto(final Calculate calculate) {
        return new CalculateDto(
                calculate.getId(),
                calculate.getTotalCostLoan(),
                calculate.getInstallments()
        );
    }
}
