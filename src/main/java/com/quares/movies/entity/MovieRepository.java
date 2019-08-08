package com.quares.movies.entity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    @Query("SELECT d FROM #{#entityName}  d WHERE d.title like %:title% and d.year=:year and d.type=:type" )
    List<MovieEntity> findByAllParameters(@Param("title") String title,
                                          @Param("year") String year,
                                          @Param("type") String type, Pageable pageable);

    @Query("SELECT d FROM #{#entityName}  d WHERE d.title like %:title%")
    List<MovieEntity> findByTitle(@Param("title") String title, Pageable pageable);

    @Query("SELECT d FROM #{#entityName}  d WHERE d.title like %:title% and d.year=:year")
    List<MovieEntity> findByTitleAndYear(@Param("title") String title, @Param("year") String year, Pageable pageable);

    @Query("SELECT d FROM #{#entityName}  d WHERE d.title like %:title% and d.type=:type")
    List<MovieEntity> findByTitleAndType(@Param("title") String title, @Param("type") String type, Pageable pageable);
}
