package com.quares.movies.dto;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ResultSearchMovieDto {
    private List<MovieDto> movieList;

    public List<MovieDto> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieDto> movieList) {
        this.movieList = movieList;
    }

    public ResultSearchMovieDto() {
        movieList= new ArrayList<>();
    }

    public ResultSearchMovieDto(List<MovieDto> movieList) {
        this.movieList = movieList;
    }

    public ResultSearchMovieDto buildByJsonObject(JSONObject response) {
        JSONArray searchList = response.getJSONArray("Search");

        this.movieList=new ArrayList<>();
        for (int i = 0, size = searchList.length(); i < size; i++)
        {
            MovieDto movieDto = new MovieDto();
            JSONObject movieInArray = searchList.getJSONObject(i);

            String[] elementNames = JSONObject.getNames(movieInArray);
            for (String elementName : elementNames)
            {
                String value = movieInArray.getString(elementName);
                switch(elementName.toLowerCase())
                {
                    case "imdbid":
                        movieDto.setImdbId(value);
                        break;
                    case "title":
                        movieDto.setTitle(value);
                        break;
                    case "type":
                        movieDto.setType(value);
                        break;
                    case "year":
                        movieDto.setYear(value);
                        break;
                    case "poster":
                        movieDto.setPoster(value);
                        break;
                    default:
                        break;
                }
            }
            this.movieList.add(movieDto);
        }

        return this;
    }

}