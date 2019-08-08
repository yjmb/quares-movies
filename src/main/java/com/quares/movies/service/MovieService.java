package com.quares.movies.service;

import com.quares.movies.dto.MovieDetailsDto;
import com.quares.movies.dto.ResultSearchMovieDto;
import com.quares.movies.dto.SearchMovieDto;

import java.io.IOException;


public interface MovieService  {

    ResultSearchMovieDto searchMovieByParameters (SearchMovieDto dto) throws IOException;

    MovieDetailsDto getItemDetail (String imdbID) throws IOException;

}
