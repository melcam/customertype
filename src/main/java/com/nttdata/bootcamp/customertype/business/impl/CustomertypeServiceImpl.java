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
  public Mono<Customertype> delete(String customertypeId) {
    Mono<Customertype> type = customertypeRepository.findById(customertypeId);

    if (type != null) {
      Mono<Customertype> type2 = Mono.fromCallable(()->{
        Customertype customertype = new Customertype();
        customertype.setType("Nuevo");
        customertype.setStatus(true);
        customertype.setDescription("Desc");
        return customertype;
      });
      type2.subscribe(e->customertypeRepository.save(e));


      //  System.out.println(x);
      //  x.setStatus(false);
        // customertypeRepository.save(x);
      //});

      return null;
    } else {
      return null;
    }
  }
  @Override
  public Mono<Customertype> activate(Customertype customertype) {
    Mono<Customertype> type = customertypeRepository.findById(customertype.getId());
    if (type != null) {
      customertype.setStatus(true);
      return customertypeRepository.save(customertype);
    } else {
      return customertypeRepository.save(customertype);
    }
  }
}
