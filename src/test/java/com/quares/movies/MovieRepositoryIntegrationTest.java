package com.quares.movies;

import com.quares.movies.entity.MovieDetailsEntity;
import com.quares.movies.entity.MovieDetailsRepository;
import com.quares.movies.entity.MovieEntity;
import com.quares.movies.entity.MovieRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieDetailsRepository movieDetailsRepository;


    Pageable pageable =PageRequest.of(0, 10);

    @Test
    public void whenFindByTitle_thenReturnMovieEntityList() {
        // given
        MovieEntity todoEntity =buildEntityPersistMock();

        // when

        List<MovieEntity> found = movieRepository.findByTitle("The Bridge",pageable);

        // then
        assert(found.get(0).getImdbId()
                .equals(todoEntity.getImdbId()));
    }

    @Test
    public void whenFindByTitleAndType_thenReturnMovieEntityList() {
        // given
        MovieEntity todoEntity =buildEntityPersistMock();

        // when

        List<MovieEntity> found = movieRepository.findByTitleAndType("The Bridge","movie", pageable);

        // then
        assert(found.get(0).getImdbId()
                .equals(todoEntity.getImdbId()));
    }

    @Test
    public void whenFindByTitleAndYear_thenReturnMovieEntityList() {
        // given
        MovieEntity todoEntity =buildEntityPersistMock();

        // when

        List<MovieEntity> found = movieRepository.findByTitleAndYear("The Bridge","2004",pageable);

        // then
        assert(found.get(0).getImdbId()
                .equals(todoEntity.getImdbId()));
    }

    @Test
    public void whenFindById_thenReturnMovieDetailsEntity() {
        // given
        MovieDetailsEntity detailsEntity= buildEntityDetailsPersistMock();

        // when

        MovieDetailsEntity found = movieDetailsRepository.findById("tt0356443");

        // then
        assert(found.getImdbId()
                .equals(detailsEntity.getImdbId()));
    }


    private MovieEntity buildEntityPersistMock(){
        MovieEntity movieEntity = new MovieEntity("tt0356443","The Bridge of San Luis Rey","movie","2004",
                "https://m.media-amazon.com/images/M/MV5BMjA0NDEwMTA2Nl5BMl5BanBnXkFtZTcwNjEyMTAzMQ@@._V1_SX300.jpg");
        entityManager.persist(movieEntity);
        entityManager.flush();
        return movieEntity;
    }

    private MovieDetailsEntity buildEntityDetailsPersistMock(){
        MovieDetailsEntity detailsEntity= new MovieDetailsEntity("tt0356443","The Bridge of San Luis Rey","movie","2004",
                "https://m.media-amazon.com/images/M/MV5BMjA0NDEwMTA2Nl5BMl5BanBnXkFtZTcwNjEyMTAzMQ@@._V1_SX300.jpg");
        entityManager.persist(detailsEntity);
        entityManager.flush();
        return detailsEntity;
    }
}
