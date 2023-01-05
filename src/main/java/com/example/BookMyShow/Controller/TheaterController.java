package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Service.impl.TheaterServiceImpl;
import com.example.BookMyShow.dto.EntryDto.TheaterEntryDto;
import com.example.BookMyShow.dto.ResponseDto.TheaterResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterServiceImpl theaterService;

    @PostMapping("/add")
    public TheaterResponseDto addTheater(@RequestBody()TheaterEntryDto theaterEntryDto){
        return theaterService.addTheater(theaterEntryDto);
    }

    @GetMapping("/{id}")
    public TheaterResponseDto getTheater(@PathVariable(value = "id") int id){
        return theaterService.getTheater(id);
    }
}
