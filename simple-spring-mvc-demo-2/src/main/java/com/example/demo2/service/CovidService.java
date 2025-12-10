package com.example.demo2.service;

import com.example.demo2.enitiy.CovidCase;
import com.example.demo2.repository.CovidCaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CovidService {

    public final CovidCaseRepository repository;

    public CovidService(CovidCaseRepository repository) {
        this.repository = repository;
    }


    public CovidCase create(CovidCase covidCase) {
        return repository.save(covidCase);
    }

    public Optional<CovidCase> findById(Long id) {
        return repository.findById(id);
    }

    public Optional<CovidCase> update(Long id, CovidCase covidCase) {
        if(!repository.existsById(id)){
            return Optional.empty();
        }
        covidCase.setId(id);
        return Optional.of(repository.save(covidCase));
    }

    public Boolean deleteById(Long id) {
        if(!repository.existsById(id)){
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    public List<CovidCase> findTop5ByField(String field) {
        return switch (field){
            case "infected" -> repository.findTop5ByOrderByInfectedDesc();
            case "recovered" -> repository.findTop5ByOrderByRecoveredDesc();
            case "deaths" -> repository.findTop5ByOrderByDeathsDesc();
            default -> List.of();
        };
    }

    public Optional<Integer> findTotalByField(String field) {
        return switch (field){
            case "infected" -> Optional.ofNullable(repository.findTotalByInfected());
            case "recovered" -> Optional.ofNullable(repository.findTotalByRecovered());
            case "deaths" -> Optional.ofNullable(repository.findTotalByDeaths());
            default -> Optional.empty();
        };
    }
}
