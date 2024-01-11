package com.wis1.loanapp.mapper;

import com.wis1.loanapp.domain.Calculate;
import com.wis1.loanapp.dto.CalculateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalculateMapper {
    private final CalcResultMapper calcResultMapper;

    public Calculate mapToCalculate(final CalculateDto calculateDto) {
        return new Calculate(
                calculateDto.getAmountLoan(),
                calculateDto.getLoanLength(),
                calcResultMapper.mapToCalcResult(calculateDto.getCalculate())
        );
    }

    public CalculateDto mapToCalculateDto(final Calculate calculate) {
        return new CalculateDto(
                calculate.getId(),
                calculate.getAmountLoan(),
                calculate.getLoanLength(),
                calcResultMapper.mapToCalcResultDto(calculate.getCalcResult())
        );
    }

    public List<CalculateDto> mapToCalculateDtoList(final List<Calculate> calculateList) {
        return calculateList.stream()
                .map(this::mapToCalculateDto)
                .collect(Collectors.toList());
    }
}
