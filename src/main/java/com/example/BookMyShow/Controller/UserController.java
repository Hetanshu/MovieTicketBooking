package com.example.BookMyShow.Controller;

import com.example.BookMyShow.Service.impl.UserServiceImpl;
import com.example.BookMyShow.dto.EntryDto.UserEntryDto;
import com.example.BookMyShow.dto.ResponseDto.UserResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDto){
//        log.info("In controller");
        userService.addUser(userEntryDto);
        return new ResponseEntity("Added User successfully", HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value = "id") int id){
        UserResponseDto userResponseDto=userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }
}
