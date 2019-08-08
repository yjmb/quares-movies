package com.quares.movies.api;

public class SearchMovieRequest {
    private String title; //Movie title to search for.
    private String type; //Type of result to return.
    private String year; //Year of release.
    private String page; //	Page number to return.

    public SearchMovieRequest() {
    }

    public SearchMovieRequest(String title, String type, String year, String page) {
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
