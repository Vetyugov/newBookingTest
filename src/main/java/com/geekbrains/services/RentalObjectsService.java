package com.geekbrains.services;

import com.geekbrains.dto.RentalObjectDto;
import com.geekbrains.entities.RentalObject;
import com.geekbrains.repositories.RentalObjectsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentalObjectsService {
    private final RentalObjectsRepository rentalObjectsRepository;

    public List<RentalObject> findAll() {
       return rentalObjectsRepository.findAll();
    }

    public Optional<RentalObject> findById(Long id) {
        return rentalObjectsRepository.findById(id);
    }

    public RentalObject save(RentalObject rentalObject) {return rentalObjectsRepository.save(rentalObject);
    }

    @Transactional
    public RentalObject update(RentalObjectDto rentalObjectDto) {
        RentalObject rentalObject = rentalObjectsRepository.findById(rentalObjectDto.getId()).orElseThrow(()-> new ResourceNotFoundException("Невозможно обновить объект аренды. Объект не найден в базе, id: " + rentalObjectDto.getId()));
        rentalObject.setTitle(rentalObject.getTitle());
        rentalObject.setPricePerNight(rentalObjectDto.getPricePerNight());
        rentalObject.setIsFree(rentalObjectDto.getIsFree());
        return rentalObject;
    }

    public void deleteById(Long id) {
        rentalObjectsRepository.deleteById(id);
    }
}
