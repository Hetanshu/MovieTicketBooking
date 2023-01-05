package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.dto.ResponseDto.TicketResponseDto;
import com.example.BookMyShow.dto.TicketDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {
    public static TicketEntity convertDtoToEntity(TicketDto ticketDto) {
        return TicketEntity.builder()
                .allottedSeats(ticketDto.getAllotted_seats())
                .amount(ticketDto.getAmount())
                .build();
    }

    public static TicketResponseDto convertEntityToDto(TicketEntity ticketEntity) {
        return TicketResponseDto.builder().id((int) ticketEntity.getId())
                .amount(ticketEntity.getAmount())
                .allotted_seats(ticketEntity.getAllottedSeats()).build();
    }
}
