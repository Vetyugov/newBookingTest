package com.geekbrains.controllers;

import com.geekbrains.converters.CityConverterBalyanova;
import com.geekbrains.dto.CitiesDtoBalyanova;
import com.geekbrains.entities.CitiesBalyanova;
import com.geekbrains.services.CitiesServiceBalyanova;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CitiesControllerBalyanova {
    private final CitiesServiceBalyanova citiesServiceBalyanova;
    private final CityConverterBalyanova cityConverterBalyanova;

    @GetMapping
    public List<CitiesDtoBalyanova> getAllCities(){
        return citiesServiceBalyanova.findAll().stream().map(cityConverterBalyanova::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public CitiesDtoBalyanova getCityById(@PathVariable Long id) {
        CitiesBalyanova city = citiesServiceBalyanova.findById(id).orElseThrow(() -> new ResourceNotFoundException("City is not found, id: " + id));
        return cityConverterBalyanova.entityToDto(city);
    }

    @PostMapping
    public CitiesDtoBalyanova saveNewCity(@RequestBody CitiesDtoBalyanova cityDto) {
        CitiesBalyanova city = cityConverterBalyanova.dtoToEntity(cityDto);
        city = citiesServiceBalyanova.save(city);
        return cityConverterBalyanova.entityToDto(city);
    }

    @PutMapping
    public CitiesDtoBalyanova updateCity(@RequestBody CitiesDtoBalyanova cityDto) {
        CitiesBalyanova city = citiesServiceBalyanova.update(cityDto);
        return cityConverterBalyanova.entityToDto(city);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        citiesServiceBalyanova.deleteById(id);
    }
}
