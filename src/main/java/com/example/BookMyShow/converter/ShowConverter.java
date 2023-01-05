package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.ShowEntity;
import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {

    public static ShowEntity convertDtoToEntity(ShowEntryDto showDto){
        return ShowEntity.builder().showTime(showDto.getShowTime()).showDate(showDto.getShowDate()).build();
    }

    public static ShowResponseDto convertEntityToDto(ShowEntity showEntity,ShowEntryDto showEntryDto){
        return ShowResponseDto.builder()
                .id(showEntity.getId())
                .showTime(showEntity.getShowTime())
                .showDate(showEntity.getShowDate())
                .movieResponseDto(showEntryDto.getMovieResponseDto())
                .theaterDto(showEntryDto.getTheaterResponseDto())
                .build();
    }
}
