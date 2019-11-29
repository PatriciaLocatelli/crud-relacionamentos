package edu.ifrs.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/ws")
public class WSConfig extends Application {
	
	public Set<Class<?>> getClasses(){
		Set<Class<?>> classes = new HashSet<>();
		classes.add(edu.ifrs.ws.CrudService.class);
		
		return classes;
	}

}