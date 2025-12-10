package com.example.demo2.controller;

import com.example.demo2.enitiy.CovidCase;
import com.example.demo2.service.CovidService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/covid")
public class CovidController {

    private final CovidService service;

    public CovidController(CovidService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CovidCase> create(@RequestBody CovidCase covidCase){
        return ResponseEntity.status(201).body(service.create(covidCase));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CovidCase> findById(@PathVariable("id") Long id){
        Optional<CovidCase> covidCase = service.findById(id);
        if(covidCase.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(covidCase.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CovidCase> update(@PathVariable Long id, @RequestBody CovidCase covidCase){
        Optional<CovidCase> covidCaseUpdated = service.update(id, covidCase);
        if(covidCaseUpdated.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(covidCaseUpdated.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        Boolean deleted = service.deleteById(id);
        if(deleted){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/top")
    public ResponseEntity<List<CovidCase>> findTop5ByField(@RequestParam("by") String field){
        List<CovidCase> covidCases = service.findTop5ByField(field);
        if(covidCases == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(covidCases);
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> findTotalByField(@RequestParam("by") String field){
        Optional<Integer> covidCases = service.findTotalByField(field);
        if(covidCases.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(covidCases.get());
    }

}
