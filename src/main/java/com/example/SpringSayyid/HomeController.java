package com.example.SpringSayyid;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	int x = 20;
	int y = 18;
	
	List<Student> list= new ArrayList<>();
	Map<Long,Student> map= new HashMap<>();
	LocalDateTime lt = LocalDateTime.now();
	
	@GetMapping("/v1/home")
	public String home() {
		
		return "Hi Student -"+ lt  ;
}		
	
	@GetMapping("/v1")
	public String home(@RequestParam String name) {
		int count=0;
		
		  for(int i = 0; i < name.length(); i++) {    
			  if (Character.isLetter(name.charAt(i)))
			         count++;
		  } 
	         if (count<8)  { 
	        	 return ("Hi Student "+name+" -"+ lt +" You are number "+ count + " and in class  " + x ) ;
	         } else {
	        	 return ("Hi Student "+name+" -"+ lt +" You are number "+ count + " and in class  " + y);
	         }
	         
	         
//		return name;
		
	}

	@PostMapping("/v1/add")
	public String add(@RequestBody Student st) {
		map.put(st.id, st);
		return st.toString();
	}
	
	@GetMapping("/v1/list")
	public Collection<Student> add() {
		return map.values();
	}
	@DeleteMapping("/v1/remove")
	public Collection<Student> remove(@RequestParam long i) {
		map.remove(i);
		return map.values();
	}
	
	@PostMapping("/v1/update")
	public Collection<Student> update(@RequestBody Student st) {
		 
		map.put(st.id, st);
		return map.values();
	}
	
	

	}
