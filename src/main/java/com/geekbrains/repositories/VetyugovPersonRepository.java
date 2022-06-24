package com.geekbrains.repositories;

import com.geekbrains.entities.VetyugovPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VetyugovPersonRepository extends JpaRepository<VetyugovPerson, Long>, JpaSpecificationExecutor<VetyugovPerson> {

}
