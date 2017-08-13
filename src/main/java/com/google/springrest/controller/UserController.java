package com.google.springrest.controller;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.springrest.constants.URI;
import com.google.springrest.entity.User;
import com.google.springrest.service.UserService;

//instead of component annotation which is generic spring uses
//@Controller
//We can add @ResponseBody at class level as well so, no need to add at each function
//@ResponseBody
//instead of using above two, spring have RestController which includes @Controller, @ResponseBody
@RestController
//We can add @RequestMapping for specific value at class level as well so, no need to add at each function
@RequestMapping(value=URI.USERS)


public class UserController {

	private UserService service;
	
	public UserController(UserService service) {
		this.service = service;
	}
	
	//whatever is returned write to the response body
	@ResponseBody
	//This method should be called on get request, with value /employees, and produces json
	//As jackson is availablein dependency it wil produxe JSON object directly
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return service.findAll();
	}
	@ResponseBody
	//here we are using, template as anything come after employees will be parsed to id
	@RequestMapping(method=RequestMethod.GET, value=URI.ID, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	//How to assign id to userId? use annotation PathVariable
	//for multiple variables, "/users/{id}/{city}" and (@PathVariable("id") String userId, @PathVariable("city") String city) 
	public User findOne(@PathVariable("id") String userId){
		return service.findOne(userId);
	}
	@ResponseBody
	//As it consumes JSON
	@RequestMapping(method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	//We are using user object from RequestBody so use @RequestBody
	public User create(@RequestBody User user){
		return service.create(user);
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT, value=URI.ID, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	//We are using id from PathVariable  so use @PathVariable, using user from RequestBody so @RequestBody
	public User update(@PathVariable("id") String id, @RequestBody User user){
		return service.update(id, user);
	}
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE, value=URI.ID, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void delete(@PathVariable("id") String id){
		service.delete(id);
	}
}
