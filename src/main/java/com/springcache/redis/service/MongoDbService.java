package com.springcache.redis.service;

import com.springcache.redis.model.Token;

public interface MongoDbService {

    Token findById(String id);

}
