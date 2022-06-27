package com.geekbrains.controllers;

import com.geekbrains.converters.RentalObjectsConverter;
import com.geekbrains.dto.RentalObjectDto;
import com.geekbrains.entities.RentalObject;
import com.geekbrains.services.RentalObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rental_objects")
@RequiredArgsConstructor
public class RentalObjectsController {
    private final RentalObjectsService rentalObjectsService;
    private final RentalObjectsConverter rentalObjectsConverter;


    @GetMapping
    public List<RentalObjectDto> getAllRentalObjects(){
        return rentalObjectsService.findAll().stream().map(rentalObjectsConverter::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RentalObjectDto getRentalObjectsById(@PathVariable Long id){
        RentalObject rentalObject = rentalObjectsService.findById(id).orElseThrow(()-> new ResourceNotFoundException("RentalObject not found, id: " + id));
        return rentalObjectsConverter.entityToDto(rentalObject);
    }

    @PostMapping
    public RentalObjectDto saveNewRentalObject(@RequestBody RentalObjectDto rentalObjectDto) {
        return rentalObjectsConverter.entityToDto(rentalObjectsService.save(rentalObjectsConverter.dtoToEntity(rentalObjectDto)));
    }

    @PutMapping
    public RentalObjectDto updateRentalObject(@RequestBody RentalObjectDto rentalObjectDto) {
        return rentalObjectsConverter.entityToDto(rentalObjectsService.update(rentalObjectDto));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        rentalObjectsService.deleteById(id);
    }

}
