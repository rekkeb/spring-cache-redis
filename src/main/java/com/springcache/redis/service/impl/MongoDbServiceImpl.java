package com.springcache.redis.service.impl;

import com.springcache.redis.model.Token;
import com.springcache.redis.repository.MongoDbRepository;
import com.springcache.redis.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MongoDbServiceImpl implements MongoDbService {

    @Autowired private MongoDbRepository mongoDbRepository;

    @Override
    @Cacheable(value="tokens")
    public Token findById(String id) {
        return mongoDbRepository.findById(id);
    }

    @Override
    @Cacheable(value = "tokens")
    public Token findByUserId(String userId) {
        return mongoDbRepository.findByUserId(userId);
    }

    @Override
    @CachePut(value="tokens", key = "#token.userId")
    public Token save(Token token) {
        return mongoDbRepository.save(token);
    }
}
