package com.quares.movies.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MovieDetailsRepository extends JpaRepository<MovieDetailsEntity, Long> {

    @Query("SELECT d FROM #{#entityName}  d WHERE d.imdbid =:imdbid")
    MovieDetailsEntity findById(@Param("imdbid") String imdbid);
}
