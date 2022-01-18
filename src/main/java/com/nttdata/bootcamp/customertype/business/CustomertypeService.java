package com.nttdata.bootcamp.customertype.business;

import com.nttdata.bootcamp.customertype.model.Customertype;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomertypeService {
  Mono<Customertype> create(Customertype customertype);

  Mono<Customertype> findById(String customertypeId);

  Flux<Customertype> findAll();

  Mono<Customertype> update(Customertype customertype);

  Mono<Customertype> delete(String customertypeId);

  Mono<Customertype> activate(Customertype customertype);
}
