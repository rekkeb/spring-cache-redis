package com.springcache.redis.repository.impl;

import com.springcache.redis.model.Token;
import com.springcache.redis.repository.MongoDbRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public class MongoDbRepositoryImpl implements MongoDbRepository {

    @Override
    public Token findById(String id) {

        System.out.println("Getting new token... '"+id+"'");

        Token t = new Token();
        t.setId(id);
        t.setUserId(UUID.randomUUID().toString());
        t.setCreatedAt(new Date());

        return t;
    }

    @Override
    public Token findByUserId(String userId) {
        System.out.println("Getting new token for ... '"+userId+"'");

        Token t = new Token();
        t.setId(UUID.randomUUID().toString());
        t.setUserId(userId);
        t.setCreatedAt(new Date());

        return t;
    }

    @Override
    public Token save(Token token) {
        System.out.println("Saved token: " + token);

        token.setId(token.getId()+"-saved");

        return token;
    }
}
