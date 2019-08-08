package com.quares.movies.dto;

import org.json.JSONObject;

public class MovieDetailsDto extends MovieDto {
    private String rated;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String writer;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String awards;
    private String metascore;
    private String imdbRating;
    private String imdbVotes;
    private String dvd;
    private String boxOffice;
    private String production;
    private String website;
    private String response;

    public MovieDetailsDto buildByJsonObject(JSONObject response) {
        String[] elementNames = JSONObject.getNames(response);
        for (String elementName : elementNames)
        {
            if (!elementName.equalsIgnoreCase("ratings")){
                String value = response.getString(elementName);
                switch(elementName.toLowerCase())
                {
                    case "imdbid":
                        this.setImdbId(value);
                        break;
                    case "title":
                        this.setTitle(value);
                        break;
                    case "type":
                        this.setType(value);
                        break;
                    case "year":
                        this.setYear(value);
                        break;
                    case "poster":
                        this.setPoster(value);
                        break;
                    case "rated":
                        this.setRated(value);
                        break;
                    case "released":
                        this.setReleased(value);
                        break;
                    case "runtime":
                        this.setRuntime(value);
                        break;
                    case "genre":
                        this.setGenre(value);
                        break;
                    case "director":
                        this.setDirector(value);
                        break;
                    case "writer":
                        this.setWriter(value);
                        break;
                    case "actors":
                        this.setActors(value);
                        break;
                    case "plot":
                        this.setPlot(value);
                        break;
                    case "language":
                        this.setLanguage(value);
                        break;
                    case "country":
                        this.setCountry(value);
                        break;
                    case "awards":
                        this.setAwards(value);
                        break;
                    case "metascore":
                        this.setMetascore(value);
                        break;
                    case "imdbrating":
                        this.setImdbRating(value);
                        break;
                    case "imdbvotes":
                        this.setImdbVotes(value);
                        break;
                    case "dvd":
                        this.setDvd(value);
                        break;
                    case "boxoffice":
                        this.setBoxOffice(value);
                        break;
                    case "production":
                        this.setProduction(value);
                        break;
                    case "website":
                        this.setWebsite(value);
                        break;
                    case "response":
                        this.setResponse(value);
                        break;
                    default:
                        break;
                }
            }

        }
        return this;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getDvd() {
        return dvd;
    }

    public void setDvd(String dvd) {
        this.dvd = dvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
