package com.example.demo2.repository;

import com.example.demo2.enitiy.CovidCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CovidCaseRepository extends JpaRepository<CovidCase, Long> {

    List<CovidCase> findTop5ByOrderByInfectedDesc();
    List<CovidCase> findTop5ByOrderByRecoveredDesc();
    List<CovidCase> findTop5ByOrderByDeathsDesc();

    @Query("SELECT SUM(c.infected) FROM CovidCase c")
    Integer findTotalByInfected();
    @Query("SELECT SUM(c.recovered) FROM CovidCase c")
    Integer findTotalByRecovered();
    @Query("SELECT SUM(c.deaths) FROM CovidCase c")
    Integer findTotalByDeaths();
}
