package com.wis1.loanapp.mapper;

import com.wis1.loanapp.domain.ScheduleItem;
import com.wis1.loanapp.dto.ScheduleItemDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleItemMapper {

    public ScheduleItem mapToScheduleItem(final ScheduleItemDto scheduleItemDto) {
        return new ScheduleItem(
                scheduleItemDto.getBalance(),
                scheduleItemDto.getInterest(),
                scheduleItemDto.getPayment(),
                scheduleItemDto.getPrincipal(),
                scheduleItemDto.getPeriod()
        );
    }

    public ScheduleItemDto mapToScheduleItemDto(final ScheduleItem scheduleItem) {
        return new ScheduleItemDto(
                scheduleItem.getId(),
                scheduleItem.getBalance(),
                scheduleItem.getInterest(),
                scheduleItem.getPayment(),
                scheduleItem.getPeriod(),
                scheduleItem.getPrincipal()
        );
    }

    public List<ScheduleItemDto> mapToScheduleItemDtoList(final List<ScheduleItem> scheduleItems) {
        return scheduleItems.stream()
                .map(this::mapToScheduleItemDto)
                .collect(Collectors.toList());
    }

    public List<ScheduleItem> mapToScheduleItemList(final List<ScheduleItemDto> scheduleItemDtos) {
        return scheduleItemDtos.stream()
                .map(this::mapToScheduleItem)
                .collect(Collectors.toList());
    }
}
