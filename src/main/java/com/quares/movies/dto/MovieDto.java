package com.quares.movies.dto;

public class MovieDto {
    private String imdbId;
    private String title;
    private String type;
    private String year;
    private String poster;

    public MovieDto() {
        //Do nothing.
    }

    public MovieDto(String imdbId, String title, String type, String year, String poster) {
        this.imdbId = imdbId;
        this.title = title;
        this.type = type;
        this.year = year;
        this.poster = poster;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
