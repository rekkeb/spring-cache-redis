package com.springcache.redis.repository.impl;

import com.springcache.redis.model.Token;
import com.springcache.redis.repository.MongoDbRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public class MongoDbRepositoryImpl implements MongoDbRepository {

    @Override
    @Cacheable(value="tokens")
    public Token findById(String id) {

        System.out.println("Getting new token... '"+id+"'");

        Token t = new Token();
        t.setId(id);
        t.setUserId(UUID.randomUUID().toString());
        t.setCreatedAt(new Date());

        return t;
    }
}
