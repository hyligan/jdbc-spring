package com.goit.jdbcspring.repo;

import com.goit.jdbcspring.entities.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepo extends CrudRepository<Worker,Long> {
}
