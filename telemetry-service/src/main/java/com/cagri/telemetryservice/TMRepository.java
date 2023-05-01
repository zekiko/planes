package com.cagri.telemetryservice;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TMRepository extends MongoRepository<TM, String> {}
