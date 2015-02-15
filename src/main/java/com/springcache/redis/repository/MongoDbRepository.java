package com.springcache.redis.repository;


import com.springcache.redis.model.Token;

public interface MongoDbRepository {

    public Token findById(String id);

}
