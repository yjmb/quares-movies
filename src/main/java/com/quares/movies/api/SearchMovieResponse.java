package com.quares.movies.api;

import com.quares.movies.dto.MovieDto;
import com.quares.movies.dto.ResultSearchMovieDto;
import java.util.List;

public class SearchMovieResponse {
    private List<MovieDto> movieList;

    public SearchMovieResponse() {
    }

    public SearchMovieResponse buildByDto(ResultSearchMovieDto dto){
        this.movieList=dto.getMovieList();
        return this;
    }

    public SearchMovieResponse(List<MovieDto> movieList) {
        this.movieList = movieList;
    }

    public List<MovieDto> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieDto> movieList) {
        this.movieList = movieList;
    }
}
