package com.example.BookMyShow.dto.EntryDto;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class MovieEntryDto {
    // Dto are built to avoid heavy api calling because it contains only required parameters

    @NotNull
    String name;

    @NotNull
    LocalDate releaseDate;
}
