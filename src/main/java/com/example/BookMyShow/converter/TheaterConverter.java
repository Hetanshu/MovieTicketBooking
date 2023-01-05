package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.TheaterEntity;
import com.example.BookMyShow.dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheaterConverter {
    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto) {
        return TheaterEntity.builder()
                .city(theaterEntryDto.getCity())
                .name(theaterEntryDto.getName())
                .address(theaterEntryDto.getAddress()).build();
    }

    public static TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity) {
        return TheaterResponseDto.builder().id(theaterEntity.getId()).name(theaterEntity.getName()).
                address(theaterEntity.getAddress()).city(theaterEntity.getCity()).type(theaterEntity.getType()).
                build();
    }
}
