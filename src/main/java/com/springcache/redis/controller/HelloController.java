package com.springcache.redis.controller;

import com.springcache.redis.model.Token;
import com.springcache.redis.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class HelloController {

	@Autowired private MongoDbService mongoDbService;

	@RequestMapping(value="/token/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Token getTokenForUserId(@PathVariable String userId) {

		return mongoDbService.findByUserId(userId);
	}

	@RequestMapping(value="/token", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void setToken(@RequestBody Token token) {

		mongoDbService.save(token);
	}
}