package com.nttdata.bootcamp.customertype.repository;

import com.nttdata.bootcamp.customertype.model.Customertype;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomertypeRepository extends ReactiveMongoRepository<Customertype, String> {
}
