package com.example.demo2.controller;

import com.example.demo2.entity.CovidCase;
import com.example.demo2.service.CovidService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/covid"))
public class CovidController {
    private final CovidService covidService;

    public CovidController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping
    public List<CovidCase> getAllCovidCase(){
        return covidService.getAllCovidCase();
    }

    @GetMapping("/{id}")
    public CovidCase getByIdCovidCase(@PathVariable Long id){
        Optional<CovidCase> found = covidService.getByIdCovidCase(id);
        return found.orElse(null);
    }

    @PostMapping
    public CovidCase addCovidCase(@RequestBody CovidCase covidCase){
        return covidService.addCovidCase(covidCase);
    }

    @PutMapping("/{id}")
    public CovidCase updateCovidCase(@PathVariable Long id, @RequestBody CovidCase covidCase){
        return covidService.updateCovidCase(id, covidCase);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCovidCase(@PathVariable Long id){
        covidService.deleteCovidCase(id);
    }
}
