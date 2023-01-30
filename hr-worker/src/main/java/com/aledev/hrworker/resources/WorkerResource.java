package com.aledev.hrworker.resources;

import com.aledev.hrworker.Repositories.WorkerRepository;
import com.aledev.hrworker.entity.Worker;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
@Slf4j
public class WorkerResource {
    private final WorkerRepository workerRepository;

    private final Environment environment;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public Worker findById(@PathVariable Long id) {
        log.info("Port = " + environment.getProperty("local.server.port"));

        var worker  = workerRepository.findById(id);
        return worker.orElse(Worker.builder().build());
    }
}
