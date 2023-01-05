package com.example.BookMyShow.converter;

import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static MovieEntity convertDtoToEntity(MovieEntryDto movieEntryDto){
        return MovieEntity.builder()
                .name(movieEntryDto.getName())
                .releaseDate(movieEntryDto.getReleaseDate()).build();
    }

    public static MovieResponseDto convertEntityToDto(MovieEntity movieEntity) {
        return MovieResponseDto.builder()
                .name(movieEntity.getName())
                .releaseDate(movieEntity.getReleaseDate()).
                id(movieEntity.getId()).build();
    }

    public static MovieNameAndIdObject convertEntityToThisObject(MovieEntity movieEntity){
        return MovieNameAndIdObject.builder()
                .id(movieEntity.getId())
                .name(movieEntity.getName()).build();
    }
}