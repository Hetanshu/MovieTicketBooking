package com.example.BookMyShow.Service;

import com.example.BookMyShow.dto.EntryDto.UserEntryDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;

public interface UserService {
    //add
    void addUser(UserEntryDto userEntryDto);

    //get
    UserResponseDto getUser(int id);
}
