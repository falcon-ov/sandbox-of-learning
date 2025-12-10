package com.example.demo2.service;


import com.example.demo2.entity.CovidCase;
import com.example.demo2.repository.CovidRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CovidService {

    private final CovidRepository covidRepository;

    public CovidService(CovidRepository covidRepository) {
        this.covidRepository = covidRepository;
    }

    public List<CovidCase> getAllCovidCase(){
        return covidRepository.findAll();
    }
    public Optional<CovidCase> getByIdCovidCase(Long id){
        return covidRepository.findById(id);
    }

    @Transactional
    public CovidCase addCovidCase(CovidCase covidCase) {
        return covidRepository.save(covidCase);
    }

    public CovidCase updateCovidCase(Long id, CovidCase covidCase) {
        if(id != null){
            covidCase.setId(id);
            covidCase.setInfected(covidCase.getInfected());
            covidCase.setDeaths(covidCase.getDeaths());
            covidCase.setRegion(covidCase.getRegion());
            covidCase.setRecovered(covidCase.getRecovered());
            return covidRepository.save(covidCase);
        }else {
            return null;
        }
    }

    public void deleteCovidCase(Long id) {
        covidRepository.deleteById(id);
    }

    public List<CovidCase> getTop5ByField(String field) {
        return switch (field) {
            case "infected"  -> covidRepository.findTop5ByOrderByInfectedDesc();
            case "recovered" -> covidRepository.findTop5ByOrderByRecoveredDesc();
            case "deaths"    -> covidRepository.findTop5ByOrderByDeathsDesc();
            default -> throw new IllegalArgumentException("Unknown field: " + field);
        };
    }

    public Long getTotal(String field) {
        return switch (field) {
            case "infected"  -> covidRepository.sumInfected();
            case "recovered" -> covidRepository.sumRecovered();
            case "deaths"    -> covidRepository.sumDeaths();
            default -> throw new IllegalArgumentException("Unknown field: " + field);
        };
    }
}
