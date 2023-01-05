package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;

public interface ShowService {

    //add show
    ShowResponseDto addShow(ShowEntryDto showEntryDto);

    //get show
    ShowResponseDto getShow(int id);
}
