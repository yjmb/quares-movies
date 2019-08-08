package com.quares.movies.dto;

import com.quares.movies.api.SearchMovieRequest;

public class SearchMovieDto {
    private String title; //Movie title to search for.
    private String type; //Type of result to return.
    private String year; //Year of release.
    private String page; //	Page number to return.

    public SearchMovieDto() {
        //Do nothing.
    }

    public String buildParameters() {
        String parameters ="";
        if (!getTitle().isEmpty()){
            parameters= parameters.concat("&s="+getTitle());
        }
        if (!getType().isEmpty()){
            parameters= parameters.concat("&type="+getType());
        }
        if (!getYear().isEmpty()){
            parameters= parameters.concat("&y="+getYear());
        }
        if (!getPage().isEmpty()){
            parameters= parameters.concat("&page="+getPage());
        }
        return parameters;
    }

    public SearchMovieDto builByRequest(SearchMovieRequest request) {
        this.title = request.getTitle();
        this.type = request.getType();
        this.year = request.getYear();
        this.page = request.getPage();
        return this;
    }

    public SearchMovieDto(String title, String type, String year, String page) {
        this.title = title;
        this.type = type;
        this.year = year;
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
