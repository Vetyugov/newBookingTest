package com.geekbrains.converters;

import com.geekbrains.dto.RentalObjectDto;
import com.geekbrains.entities.RentalObject;
import org.springframework.stereotype.Component;

@Component
public class RentalObjectsConverter {
    public RentalObjectDto entityToDto(RentalObject rentalObject){
        return new RentalObjectDto(rentalObject.getId(), rentalObject.getTitle(), rentalObject.getPricePerNight(), rentalObject.getIsFree());
    }

    public RentalObject dtoToEntity(RentalObjectDto rentalObjectDto) {
        return  new RentalObject(rentalObjectDto.getId(), rentalObjectDto.getTitle(), rentalObjectDto.getPricePerNight(), rentalObjectDto.getIsFree());
    }
}
