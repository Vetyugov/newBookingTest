package com.geekbrains.services;

import com.geekbrains.dto.VetyugovPersonDto;
import com.geekbrains.entities.VetyugovPerson;
import com.geekbrains.repositories.VetyugovPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VetyugovService {
    private final VetyugovPersonRepository vetyugovPersonRepository;

    public List<VetyugovPerson> findAll() {
        return vetyugovPersonRepository.findAll();
    }

    public Optional<VetyugovPerson> findById(Long id) {
        return vetyugovPersonRepository.findById(id);
    }

    public void deleteById(Long id) {
        vetyugovPersonRepository.deleteById(id);
    }

    public VetyugovPerson save(VetyugovPerson product) {
        return vetyugovPersonRepository.save(product);
    }

    @Transactional
    public VetyugovPerson update(VetyugovPersonDto personDto) {
        VetyugovPerson product = vetyugovPersonRepository.findById(personDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить пользователя, не надйен в базе, id: " + personDto.getId()));
        product.setUsername(personDto.getUsername());
        product.setIsAdmin(personDto.getIsAdmin());
        return product;
    }
}
