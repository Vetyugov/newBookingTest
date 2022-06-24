package com.geekbrains.controllers;


import com.geekbrains.converters.VetyugovPersonConverter;
import com.geekbrains.dto.VetyugovPersonDto;
import com.geekbrains.entities.VetyugovPerson;
import com.geekbrains.services.VetyugovService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class VetyugovCrudController {
    private final VetyugovService personService;
    private final VetyugovPersonConverter personConverter;
    @GetMapping
    public List<VetyugovPersonDto> getAllPersons(){
        return personService.findAll().stream().map(p->personConverter.entityToDto(p)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public VetyugovPersonDto getProductById(@PathVariable Long id) {
        VetyugovPerson person = personService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found, id: " + id));
        return personConverter.entityToDto(person);
    }

    @PostMapping
    public VetyugovPersonDto saveNewProduct(@RequestBody VetyugovPersonDto personDto) {
        VetyugovPerson person = personConverter.dtoToEntity(personDto);
        person = personService.save(person);
        return personConverter.entityToDto(person);
    }

    @PutMapping
    public VetyugovPersonDto updateProduct(@RequestBody VetyugovPersonDto personDto) {
        VetyugovPerson person = personService.update(personDto);
        return personConverter.entityToDto(person);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        personService.deleteById(id);
    }

}
