package com.quares.movies.dao.impl;

import com.quares.movies.dao.MovieDao;
import com.quares.movies.dto.MovieDetailsDto;
import com.quares.movies.dto.MovieDto;
import com.quares.movies.dto.ResultSearchMovieDto;
import com.quares.movies.dto.SearchMovieDto;
import com.quares.movies.entity.MovieDetailsEntity;
import com.quares.movies.entity.MovieDetailsRepository;
import com.quares.movies.entity.MovieEntity;
import com.quares.movies.entity.MovieRepository;
import com.quares.movies.properties.Properties;
import com.quares.movies.utils.HTTPResponseCodesEnum;
import org.dozer.Mapper;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;


@Service
public class MovieDaoImpl implements MovieDao {
    protected static final Logger LOGGER = LoggerFactory.getLogger(MovieDaoImpl.class);
    private static final int PAGE_SIZE =10;

    @Autowired
    Mapper mapper;
    @Autowired
    Properties properties;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    @Override
    public ResultSearchMovieDto searchMovieByParameters(SearchMovieDto dto) throws IOException {
        ResultSearchMovieDto result = searchForCache(dto);
        if(result==null){
            URL url = new URL(properties.getUriOMBDApi()
                    +"?apikey="+ properties.getApiKey()
                    + dto.buildParameters());

            JSONObject jsonObject= consumerAPI (url);
            result=new ResultSearchMovieDto().buildByJsonObject(jsonObject);
            saveMovieInCache(result.getMovieList());
        }
        return result;
    }

    @Override
    public MovieDetailsDto getMovieDetails(String imdbID) throws IOException {
        MovieDetailsDto result= searchForCache(imdbID);
        if(result == null){
            URL url = new URL(properties.getUriOMBDApi()
                    +"?apikey="+ properties.getApiKey()
                    + "&i="+ imdbID);

            JSONObject jsonObject= consumerAPI (url);
            result= new MovieDetailsDto().buildByJsonObject(jsonObject);
            saveMovieDetailsInCache(result);
        }
        return result;
    }

    private JSONObject consumerAPI (URL url) throws IOException {
        JSONObject jsonObject =null;
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(RequestMethod.GET.toString());
        conn.setRequestProperty("Accept", "application/json");
        if (!String.valueOf(conn.getResponseCode()).equals(HTTPResponseCodesEnum.STATUS_200.getStatusCode())) {
            LOGGER.debug("Failed : HTTP Error code : "
                    + conn.getResponseCode()+". URL: " + url.toString());
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output = br.readLine();
        if (!output.isEmpty()) {
            jsonObject = new JSONObject(output);
        }
        conn.disconnect();
        return jsonObject;
    }


    private ResultSearchMovieDto searchForCache(SearchMovieDto dto){
        //Paginación
        int pageNumber = (dto.getPage().isEmpty())? 0 : Integer.parseInt(dto.getPage());
        Pageable pageable =PageRequest.of(pageNumber, PAGE_SIZE);

        ResultSearchMovieDto result = new ResultSearchMovieDto();
        List<MovieEntity> movieEntityList;
        if (!dto.getYear().isEmpty() && !dto.getType().isEmpty()){
            movieEntityList= movieRepository.findByAllParameters(dto.getTitle(),dto.getYear(),dto.getType(),pageable);
        }else if(!dto.getYear().isEmpty() ){
            movieEntityList= movieRepository.findByTitleAndYear(dto.getTitle(),dto.getYear(),pageable);
        }else if(!dto.getType().isEmpty() ){
            movieEntityList= movieRepository.findByTitleAndType(dto.getTitle(),dto.getType(),pageable);
        }else{
            movieEntityList= movieRepository.findByTitle(dto.getTitle(),pageable);
        }

        for(MovieEntity entity : movieEntityList){
            result.getMovieList().add(mapper.map(entity, MovieDto.class));
        }
        if (!result.getMovieList().isEmpty()){
            return result;
        }
        return  null;
    }

    private MovieDetailsDto searchForCache(String imdbID){
        MovieDetailsEntity entity = movieDetailsRepository.findById(imdbID);
        if (entity!=null){
            return mapper.map(entity, MovieDetailsDto.class);
        }
        return  null;
    }

    private void saveMovieInCache(List<MovieDto> movieDtoList){
        for (MovieDto dto : movieDtoList){
            try{
                movieRepository.save(mapper.map(dto, MovieEntity.class));
            }catch (Exception e){
                LOGGER.debug("No se pudo guardar la película en cache. ImdbId="+dto.getImdbId()+
                        ". "+e.getMessage() );
            }
        }
    }

    private void saveMovieDetailsInCache(MovieDetailsDto movieDetailsDto){
        try{
            movieDetailsRepository.save(mapper.map(movieDetailsDto, MovieDetailsEntity.class));
        }catch (Exception e){
            LOGGER.debug("No se pudo guardar la película en cache. ImdbId="+movieDetailsDto.getImdbId()+
                    ". "+e.getMessage() );
        }
    }


}
