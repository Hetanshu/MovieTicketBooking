package com.example.BookMyShow.dto.ResponseDto;

import com.example.BookMyShow.Model.TicketEntity;
import com.example.BookMyShow.dto.TicketDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {

    int id;
    String name;
    String mobNo;

    // Optional
//    List<TicketDto> tickets;
}
