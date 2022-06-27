package com.geekbrains.repositories;

import com.geekbrains.entities.RentalObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalObjectsRepository extends JpaRepository<RentalObject, Long>, JpaSpecificationExecutor<RentalObject> {
}
