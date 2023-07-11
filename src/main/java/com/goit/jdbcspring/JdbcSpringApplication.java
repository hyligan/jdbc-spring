package com.goit.jdbcspring;

import com.goit.jdbcspring.entities.Worker;
import com.goit.jdbcspring.repo.WorkerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.sql.Date;

@SpringBootApplication
public class JdbcSpringApplication {

	public JdbcSpringApplication(WorkerRepo workerRepo) {
		Worker worker = new Worker();
		worker.setBirthday(new Date(System.currentTimeMillis()));
		worker.setName("test");
		worker.setLevel("Jun");
		worker.setSalary(BigDecimal.valueOf(500));
		workerRepo.save(worker);
		for (Worker worker1 : workerRepo.findAll()) {
			System.out.println(worker1);
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(JdbcSpringApplication.class, args);
	}



}
