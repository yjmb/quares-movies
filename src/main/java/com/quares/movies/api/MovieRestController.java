package com.quares.movies.api;

import com.quares.movies.service.MovieService;
import com.quares.movies.dto.MovieDetailsDto;
import com.quares.movies.dto.ResultSearchMovieDto;
import com.quares.movies.dto.SearchMovieDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieRestController {
    @Autowired
    MovieService movieService;

    @PostMapping (value="/movielist")
    @ResponseBody
    public MovieResponse<SearchMovieResponse> getMovieList(@RequestBody SearchMovieRequest request, MovieResponse<SearchMovieResponse> response) {
        try {
            ResultSearchMovieDto result  = movieService.searchMovieByParameters(new SearchMovieDto().builByRequest(request));
            response.setResult(new SearchMovieResponse().buildByDto(result));
            return response.toStatus200OK();
        }catch (Exception e){
            return response.toStatus500InternalServerError();
        }

    }

    @GetMapping(value="/itemdetail")
    @ResponseBody
    public MovieResponse<MovieDetailsDto> getItemDetail(@RequestParam(required = false) String imdbID, MovieResponse<MovieDetailsDto> response){
        try {
            MovieDetailsDto result  = movieService.getItemDetail(imdbID);
            response.setResult(result);
            return response.toStatus200OK();
        }catch (Exception e){
            return response.toStatus500InternalServerError();
        }

    }

}
