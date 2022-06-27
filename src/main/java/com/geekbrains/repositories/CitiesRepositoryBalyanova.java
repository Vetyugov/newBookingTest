package com.geekbrains.repositories;

import com.geekbrains.entities.CitiesBalyanova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CitiesRepositoryBalyanova extends JpaRepository<CitiesBalyanova, Long>, JpaSpecificationExecutor<CitiesBalyanova> {
}
