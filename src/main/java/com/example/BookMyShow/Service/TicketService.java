package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.BookTicketRequestDto;
import com.example.BookMyShow.dto.ResponseDto.TicketResponseDto;


public interface TicketService {

    TicketResponseDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

    TicketResponseDto getTicket(int id);
}
