package com.cecep.web;



import javax.jws.WebService;

@WebService
public interface PersonServiceI {
	
	String addOrUpdatePerson(String json);

}
