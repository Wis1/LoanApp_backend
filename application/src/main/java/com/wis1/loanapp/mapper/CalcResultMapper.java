package com.wis1.loanapp.mapper;

import com.wis1.loanapp.domain.CalcResult;
import com.wis1.loanapp.dto.CalcResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalcResultMapper {

    private final ScheduleItemMapper scheduleItemMapper;

    public CalcResult mapToCalcResult(final CalcResultDto calcResultDto) {
        return new CalcResult(
                calcResultDto.getInterest_rate(),
                calcResultDto.getLoan_interest(),
                calcResultDto.getLoan_amount(),
                calcResultDto.getLoan_type(),
                calcResultDto.getMonthly_payment(),
                calcResultDto.getRepayment_term(),
                scheduleItemMapper.mapToScheduleItemList(calcResultDto.getSchedule())
        );
    }

    public CalcResultDto mapToCalcResultDto(final CalcResult calcResult) {
        return new CalcResultDto(
                calcResult.getId(),
                calcResult.getInterest_rate(),
                calcResult.getLoan_interest(),
                calcResult.getLoan_amount(),
                calcResult.getLoan_type(),
                calcResult.getMonthly_payment(),
                calcResult.getRepayment_term(),
                scheduleItemMapper.mapToScheduleItemDtoList(calcResult.getSchedule())
        );
    }

    public List<CalcResultDto> mapToCalcResultDtoList(final List<CalcResult> calcResultList) {
        return calcResultList.stream()
                .map(this::mapToCalcResultDto)
                .collect(Collectors.toList());
    }
}
