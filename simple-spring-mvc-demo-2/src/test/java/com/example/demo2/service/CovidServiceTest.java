package com.example.demo2.service;

import com.example.demo2.enitiy.CovidCase;
import com.example.demo2.repository.CovidCaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CovidServiceTest {

    @Mock
    private CovidCaseRepository repository;

    @InjectMocks
    private CovidService service;

    @Test
    void create_whenValid_thenReturnNewRecord(){
        CovidCase c = new CovidCase();
        c.setRegion("Test");

        when(repository.save(any())).thenReturn(c);

        CovidCase result = service.create(c);

        assertEquals("Test", result.getRegion());
        verify(repository).save(any());
    }

    @Test
    void getById_whenExistingId_thenReturnTheRecord() {
        CovidCase c = new CovidCase();
        c.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(c));

        Optional<CovidCase> result = service.findById(1L);

        assertFalse(result.isEmpty());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void update_whenValidAndExistingId_thenReturnUpdatedRecord(){
        CovidCase c = new CovidCase();
        c.setId(1L);

        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(c)).thenReturn(c);

        Optional<CovidCase> result = service.update(1L, c);

        assertFalse(result.isEmpty());
        assertEquals(1L, result.get().getId());
    }

    @Test
    void deleteById_whenExistingId_thenReturnTrue(){
        CovidCase c = new CovidCase();
        c.setId(1L);

        when(repository.existsById(1L)).thenReturn(true);

        Boolean result = service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
        assertTrue(result);
    }

    @Test
    void findTop6ByField_whenInfected_thenReturnTop5List(){
        CovidCase c = new CovidCase();
        List<CovidCase> top5ByInfected = new ArrayList<>(Arrays.asList(c, c, c, c, c));

        when(repository.findTop5ByOrderByInfectedDesc()).thenReturn(top5ByInfected);

        assertEquals(top5ByInfected, service.findTop5ByField("infected"));
    }

    @Test
    void findTop6ByField_whenRecovered_thenReturnTop5List(){
        CovidCase c = new CovidCase();
        List<CovidCase> top5ByRecovered = new ArrayList<>(Arrays.asList(c, c, c, c, c));

        when(repository.findTop5ByOrderByRecoveredDesc()).thenReturn(top5ByRecovered);

        assertEquals(top5ByRecovered, service.findTop5ByField("recovered"));
    }

    @Test
    void findTop6ByField_whenDeaths_thenReturnTop5List(){
        CovidCase c = new CovidCase();
        List<CovidCase> top5ByDeaths = new ArrayList<>(Arrays.asList(c, c, c, c, c));

        when(repository.findTop5ByOrderByDeathsDesc()).thenReturn(top5ByDeaths);

        assertEquals(top5ByDeaths, service.findTop5ByField("deaths"));
    }

    @Test
    void getTotal_whenInfected_thenReturnTotal(){
        when(repository.findTotalByInfected()).thenReturn(100);

        Optional<Integer> result = service.findTotalByField("infected");

        assertFalse(result.isEmpty());
        assertEquals(100, result.get());
    }

    @Test
    void getTotal_whenRecovered_thenReturnTotal(){
        when(repository.findTotalByRecovered()).thenReturn(200);

        Optional<Integer> result = service.findTotalByField("recovered");

        assertFalse(result.isEmpty());
        assertEquals(200, result.get());
    }

    @Test
    void getTotal_whenDeaths_thenReturnTotal(){
        when(repository.findTotalByDeaths()).thenReturn(100);

        Optional<Integer> result = service.findTotalByField("deaths");

        assertFalse(result.isEmpty());
        assertEquals(100, result.get());
    }
}








