package com.quares.movies.service.impl;

import com.quares.movies.service.MovieService;
import com.quares.movies.dao.MovieDao;
import com.quares.movies.dto.MovieDetailsDto;
import com.quares.movies.dto.ResultSearchMovieDto;
import com.quares.movies.dto.SearchMovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MovieServieImpl implements MovieService {
    @Autowired
    MovieDao movieDao;

    @Override
    public ResultSearchMovieDto searchMovieByParameters(SearchMovieDto dto) throws IOException{
        return movieDao.searchMovieByParameters(dto);
    }

    @Override
    public MovieDetailsDto getItemDetail(String imdbID) throws IOException {
        return movieDao.getMovieDetails(imdbID);
    }

}
