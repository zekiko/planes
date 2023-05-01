package com.cagri.telecommandservice.repository;

import com.cagri.telecommandservice.model.TC;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TCRepository extends MongoRepository<TC, String> {}
