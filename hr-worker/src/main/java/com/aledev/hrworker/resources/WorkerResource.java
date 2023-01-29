package com.aledev.hrworker.resources;

import com.aledev.hrworker.Repositories.WorkerRepository;
import com.aledev.hrworker.entity.Worker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
@RequiredArgsConstructor
public class WorkerResource {
    private final WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = workerRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/{id}")
    public Worker findById(@PathVariable Long id) {
        var worker  = workerRepository.findById(id);
        return worker.orElse(Worker.builder().build());
    }
}
