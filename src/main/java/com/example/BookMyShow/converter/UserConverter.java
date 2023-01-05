package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.UserEntity;
import com.example.BookMyShow.dto.EntryDto.UserEntryDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConverter {

    public static UserEntity convertDtoToEntity(UserEntryDto userEntryDto){
        return UserEntity.builder()
                .name(userEntryDto.getName())
                .mobile(userEntryDto.getMobile()).build();

        // .builder() is a method to create object
        // Second method for creating the object using "new" keyword
    }

    public static UserResponseDto convertEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .mobNo(userEntity.getMobile()).build();
    }
}
