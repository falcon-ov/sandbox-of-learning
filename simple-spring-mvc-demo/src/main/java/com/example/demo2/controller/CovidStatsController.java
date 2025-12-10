package com.example.demo2.controller;

import com.example.demo2.entity.CovidCase;
import com.example.demo2.service.CovidService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(("/covid"))
public class CovidStatsController {
    private final CovidService covidService;

    public CovidStatsController(CovidService covidService) {
        this.covidService = covidService;
    }

    @GetMapping("/search")
    public CovidCase searchById(@RequestParam("id") Long id) {
        Optional<CovidCase> found = covidService.getByIdCovidCase(id);
        return found.orElse(null);
    }

    @GetMapping("/top5")
    public List<CovidCase> searchAll(@RequestParam("by") String field){
        return covidService.getTop5ByField(field);
    }

    @GetMapping("/total")
    public Long getTotal(@RequestParam("by") String field){
        return covidService.getTotal(field);
    }
}
