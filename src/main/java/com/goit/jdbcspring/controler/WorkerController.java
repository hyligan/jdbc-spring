package com.goit.jdbcspring.controler;

import com.goit.jdbcspring.JdbcSpringApplication;
import com.goit.jdbcspring.dto.SalaryDto;
import com.goit.jdbcspring.dto.WorkerDto;
import com.goit.jdbcspring.entities.Worker;
import com.goit.jdbcspring.repo.WorkerRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/workers")
public class WorkerController {
    Logger logger = LogManager.getLogger(WorkerController.class);


    private final WorkerRepo workerRepo;

    public WorkerController(WorkerRepo workerRepo) {
        this.workerRepo = workerRepo;
    }
    @GetMapping("/all")
    public Iterable<Worker> getAllWorkers(){
        Iterable<Worker> all = workerRepo.findAll();
        logger.info("getAllWorkers {}",all);
        return all;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody Worker getWorker(@PathVariable("id") Long id){
        Worker worker = workerRepo.findById(id).get();
        logger.info("getWorker id = {}, resp = {}",id,worker);
        return worker;
    }

    @PostMapping
    public @ResponseBody Worker createWorker(@RequestBody @Valid WorkerDto workerDto){
        Worker worker = new Worker();
        worker.setName(workerDto.getName());
        worker.setBirthday(workerDto.getBirthday());
        worker.setLevel("Jun");
        worker.setSalary(BigDecimal.ZERO);
        Worker save = workerRepo.save(worker);
        logger.info("createWorker WorkerDto = {}, resp = {}",workerDto,save);
        return save;
    }

    @PutMapping("/{id}")
    public @ResponseBody Worker updateWorker(@PathVariable("id") Long id,
            @RequestBody SalaryDto salaryDto){
        Worker worker = workerRepo.findById(id).get();
        worker.setSalary(salaryDto.getSalary());
        switch (salaryDto.getSalary().intValue()){
            case 500:
                worker.setLevel("Jun");
                break;
            case 1000:
                worker.setLevel("Mid");
                break;
            case 3000:
                worker.setLevel("Sin");
                break;
            case 5000:
                worker.setLevel("Tech");
                break;
            default:
                worker.setLevel("Jun");
        }
        return workerRepo.save(worker);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        workerRepo.deleteById(id);
    }
}
