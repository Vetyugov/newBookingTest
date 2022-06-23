package com.geekbrains.repository;

import com.geekbrains.entity.Task;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer> {

    List<Task> findAll(Sort by);
}
