package com.example.BookMyShow.dto;

import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDto {
    int id;
    String allotted_seats;
    double amount;
    ShowResponseDto showDto;

    @NotNull
    UserResponseDto userDto; // Mandatory for me to fill this userDto value
}
