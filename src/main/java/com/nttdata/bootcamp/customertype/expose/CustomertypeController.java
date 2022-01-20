package com.nttdata.bootcamp.customertype.expose;

import com.nttdata.bootcamp.customertype.business.CustomertypeService;
import com.nttdata.bootcamp.customertype.model.Customertype;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
public class CustomertypeController {

    @Autowired
    private CustomertypeService customertypeService;

    @GetMapping("/api/customertypes/{id}")
    public Mono<Customertype> findById(@PathVariable("id") String id) {
        log.info("<--findById-->");
        return customertypeService.findById(id);
    }

    @GetMapping("/api/customertypes")
    public Flux<Customertype> findAll() {
        log.info("<--findAll-->");
        return customertypeService.findAll();
    }

    @PostMapping("/api/customertypes")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customertype> create(@RequestBody Customertype customertype) {
        log.info("<--create-->");
        return customertypeService.create(customertype);
    }

    @PutMapping("/api/customertypes")
    public Mono<Customertype> update(@RequestBody Customertype customertype) {
        log.info("<--update-->");
        return customertypeService.update(customertype);
    }

    @PatchMapping("/api/customertypes")
    public Mono<ResponseEntity<Customertype>> change(@RequestBody Customertype customertype) {
        log.info("<--change-->");
        return customertypeService.change(customertype).flatMap(ctUpdate -> Mono.just(ResponseEntity.ok(ctUpdate)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @DeleteMapping("/api/customertypes/{id}")
    public Mono<ResponseEntity<Customertype>> delete(@PathVariable("id") String id) {
        log.info("<--delete-->");
        return customertypeService.delete(id).flatMap(ct -> Mono.just(ResponseEntity.ok(ct)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
