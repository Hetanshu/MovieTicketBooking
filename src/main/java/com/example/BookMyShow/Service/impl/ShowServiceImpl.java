package com.example.BookMyShow.Service.impl;

import com.example.BookMyShow.Model.*;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.ShowSeatsRepository;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.Service.ShowService;
import com.example.BookMyShow.converter.MovieConverter;
import com.example.BookMyShow.converter.ShowConverter;
import com.example.BookMyShow.converter.TheaterConverter;
import com.example.BookMyShow.dto.EntryDto.ShowEntryDto;
import com.example.BookMyShow.dto.ResponseDto.ShowResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ShowServiceImpl implements ShowService {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showEntryDto) {
        ShowEntity showEntity= ShowConverter.convertDtoToEntity(showEntryDto);

        //MovieEntity
        MovieEntity movieEntity=movieRepository.findById(showEntryDto.getMovieResponseDto().getId()).get();
        showEntity.setMovie(movieEntity);

        TheaterEntity  theaterEntity=theaterRepository.findById(showEntryDto.getTheaterResponseDto().getId()).get();
        showEntity.setTheater(theaterEntity);

        showEntity=showRepository.save(showEntity);

        List<ShowSeatsEntity> showSeatsEntityList=generateShowEntitySeats(theaterEntity.getSeats(),showEntity);
        showSeatsRepository.saveAll(showSeatsEntityList);

        ShowResponseDto showResponseDto=ShowConverter.convertEntityToDto(showEntity,showEntryDto);
        return showResponseDto;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        ShowEntity showEntity=showRepository.findById(id).get();
        return ShowResponseDto.builder()
                .id(showEntity.getId()).showDate(showEntity.getShowDate())
                .showTime(showEntity.getShowTime())
                .movieResponseDto(MovieConverter.convertEntityToDto(showEntity.getMovie()))
                .theaterDto(TheaterConverter.convertEntityToDto(showEntity.getTheater())).build();
    }


    public List<ShowSeatsEntity> generateShowEntitySeats(List<TheaterSeatsEntity> theaterSeatsEntityList, ShowEntity showEntity){
        List<ShowSeatsEntity> showSeatsEntityList=new ArrayList<>();
        for(TheaterSeatsEntity seat:theaterSeatsEntityList){
            ShowSeatsEntity showSeatsEntity=ShowSeatsEntity.builder()
                    .seatNumber(seat.getSeatNumber())
                    .seatType(seat.getSeatType())
                    .rate(seat.getRate()).build();
            showSeatsEntityList.add(showSeatsEntity);
        }

        for(ShowSeatsEntity showSeatsEntity:showSeatsEntityList){
            showSeatsEntity.setShow(showEntity);
        }

        showEntity.setSeats(showSeatsEntityList);
        return showSeatsEntityList;
    }
}
