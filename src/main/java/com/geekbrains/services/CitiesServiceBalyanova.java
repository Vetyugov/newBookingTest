package com.geekbrains.services;

import com.geekbrains.dto.CitiesDtoBalyanova;
import com.geekbrains.entities.CitiesBalyanova;
import com.geekbrains.repositories.CitiesRepositoryBalyanova;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CitiesServiceBalyanova {
    private final CitiesRepositoryBalyanova citiesRepositoryBalyanova;

    public List<CitiesBalyanova> findAll() {
        return citiesRepositoryBalyanova.findAll();
    }

    public Optional<CitiesBalyanova> findById(Long id) {
        return citiesRepositoryBalyanova.findById(id);
    }

    public void deleteById(Long id) {
        citiesRepositoryBalyanova.deleteById(id);
    }

    public CitiesBalyanova save(CitiesBalyanova city) {
        return citiesRepositoryBalyanova.save(city);
    }

    @Transactional
    public CitiesBalyanova update(CitiesDtoBalyanova cityDto) {
        CitiesBalyanova city = citiesRepositoryBalyanova.findById(cityDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Unable to update city, not found in database, id: " + cityDto.getId()));
        city.setCity(cityDto.getCity());
        return city;
    }
}
