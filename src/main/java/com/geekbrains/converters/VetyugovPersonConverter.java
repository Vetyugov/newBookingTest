package com.geekbrains.converters;

import com.geekbrains.dto.VetyugovPersonDto;
import com.geekbrains.entities.VetyugovPerson;
import org.springframework.stereotype.Component;

@Component
public class VetyugovPersonConverter {
    public VetyugovPerson dtoToEntity(VetyugovPersonDto personDto) {
        return new VetyugovPerson(personDto.getId(), personDto.getUsername(), personDto.getIsAdmin());
    }

    public VetyugovPersonDto entityToDto(VetyugovPerson person) {
        return new VetyugovPersonDto(person.getId(), person.getUsername(), person.getIsAdmin());
    }
}
