package com.example.demo2.repository;

import com.example.demo2.entity.CovidCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CovidRepository extends JpaRepository<CovidCase, Long> {
    List<CovidCase> findTop5ByOrderByInfectedDesc();
    List<CovidCase> findTop5ByOrderByRecoveredDesc();
    List<CovidCase> findTop5ByOrderByDeathsDesc();

    @Query("SELECT SUM(c.infected) FROM CovidCase c")
    Long sumInfected();

    @Query("SELECT SUM(c.recovered) FROM CovidCase c")
    Long sumRecovered();

    @Query("SELECT SUM(c.deaths) FROM CovidCase c")
    Long sumDeaths();
}
