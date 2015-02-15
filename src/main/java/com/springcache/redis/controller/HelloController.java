package com.springcache.redis.controller;

import com.springcache.redis.model.Token;
import com.springcache.redis.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class HelloController {

	@Autowired private MongoDbService mongoDbService;

	@RequestMapping(value="/token/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Token getToken(@PathVariable String id) {

		return mongoDbService.findById(id);
	}
}