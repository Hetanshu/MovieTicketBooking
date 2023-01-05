package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.MovieEntity;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Service.MovieService;
import com.example.BookMyShow.converter.MovieConverter;
import com.example.BookMyShow.dto.EntryDto.MovieEntryDto;
import com.example.BookMyShow.dto.ResponseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.ResponseDto.MovieResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;


    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieEntryDto) {
        MovieResponseDto movieResponseDto=null;
        if(movieRepository.existsByName(movieEntryDto.getName())){
            movieResponseDto.setName("This movie is already Existing");
            return movieResponseDto;
        }

        log.info("In the function add movie"+movieEntryDto);
        MovieEntity movieEntity= MovieConverter.convertDtoToEntity(movieEntryDto);
        movieEntity=movieRepository.save(movieEntity);
        movieResponseDto=MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;
    }

    @Override
    public MovieResponseDto getMovie(int id) {
        MovieEntity movieEntity=movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto=MovieConverter.convertEntityToDto(movieEntity);
        return movieResponseDto;
    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id){
        MovieEntity movieEntity=movieRepository.findById(id).get();

        MovieNameAndIdObject obj=MovieConverter.convertEntityToThisObject(movieEntity);
        return obj;
    }
}
