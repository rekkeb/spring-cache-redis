package com.springcache.redis.repository;


import com.springcache.redis.model.Token;

public interface MongoDbRepository {

    Token findById(String id);

    Token findByUserId(String userId);

    Token save(Token token);

}
