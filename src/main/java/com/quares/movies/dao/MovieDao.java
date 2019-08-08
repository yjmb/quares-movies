package com.quares.movies.dao;

import com.quares.movies.dto.MovieDetailsDto;
import com.quares.movies.dto.ResultSearchMovieDto;
import com.quares.movies.dto.SearchMovieDto;

import java.io.IOException;

public interface MovieDao {

    ResultSearchMovieDto searchMovieByParameters (SearchMovieDto dto) throws IOException;

    MovieDetailsDto getMovieDetails (String imdbID) throws IOException;


}
