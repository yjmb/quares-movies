package com.quares.movies.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class MovieEntity implements Serializable {
    private static final long serialVersionUID = 4894;

    @Id
    private String imdbid;
    private String title;
    private String type;
    private String year;
    private String poster;

    public MovieEntity(String imdbid, String title, String type, String year, String poster) {
        this.imdbid = imdbid;
        this.title = title;
        this.type = type;
        this.year = year;
        this.poster = poster;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getImdbId() {
        return imdbid;
    }

    public void setImdbId(String imdbId) {
        this.imdbid = imdbId;
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
}
