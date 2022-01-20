package com.nttdata.bootcamp.customertype.business.impl;

import com.nttdata.bootcamp.customertype.business.CustomertypeService;
import com.nttdata.bootcamp.customertype.model.Customertype;
import com.nttdata.bootcamp.customertype.repository.CustomertypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomertypeServiceImpl implements CustomertypeService {
  @Autowired
  private CustomertypeRepository customertypeRepository;

  @Override
  public Mono<Customertype> create(Customertype customertype) {
    customertype.setStatus(true);
    return customertypeRepository.save(customertype);
  }

  @Override
  public Mono<Customertype> findById(String customertypeId) {
    return customertypeRepository.findById(customertypeId);
  }

  @Override
  public Flux<Customertype> findAll() {
    return customertypeRepository.findAll();
  }

  @Override
  public Mono<Customertype> update(Customertype customertype) {
    return customertypeRepository.findById(customertype.getId()).map(ct -> customertype)
        .flatMap(this.customertypeRepository::save);
  }

  @Override
  public Mono<Customertype> change(Customertype customertype) {
    return customertypeRepository.findById(customertype.getId()).flatMap(ct -> {
      return create(customertype);
    }).switchIfEmpty(Mono.empty());
  }

  @Override
  public Mono<Customertype> delete(String id) {
    return customertypeRepository.findById(id)
        .flatMap(ct -> customertypeRepository.deleteById(ct.getId()).thenReturn(ct));
  }

}
