package com.nttdata.bootcamp.customertype.expose;

import com.nttdata.bootcamp.customertype.business.CustomertypeService;
import com.nttdata.bootcamp.customertype.model.Customertype;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        log.info("findById>>>>>>>>");
        return customertypeService.findById(id);
    }

    @GetMapping("/api/customertypes")
    public Flux<Customertype> findAll() {
        log.info("findAll>>>>>");
        return customertypeService.findAll();
    }

    @PostMapping("/api/customertypes")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customertype> create(@RequestBody Customertype customertype) {
        log.info("create>>>>");
        return customertypeService.create(customertype);
    }

    @PutMapping("/api/customertypes")
    public Mono<Customertype> update(@RequestBody Customertype customertype) {
        log.info("update>>>>>>>>>>");
        return customertypeService.update(customertype);
    }

    @PutMapping("/api/customertypes/delete/{id}")
    public Mono<Customertype> delete(@PathVariable("id") String id) {
        log.info("delete>>>>>>>>>>");
        return customertypeService.delete(id);
    }
    @PutMapping("/api/customertypes/activate")
    public Mono<Customertype> activate(@RequestBody Customertype customertype) {
        log.info("activate>>>>>>>>>>");
        return customertypeService.activate(customertype);
    }
}
