package fi.haagahelia.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody

public class HelloController {
	@RequestMapping("/index")
	public String index() {
		return "This is the main page";
	}
	@RequestMapping("/contact")
	public String contact() {
		return "This is the contact page";
	}
	@RequestMapping("/hello")
	public String hi(@RequestParam(name="location",required=false, defaultValue="nowhere") String location, 
					@RequestParam(name="name",required=false, defaultValue="Stranger") String name) {
			return "Welcome to " + location+ " " + name;
			}
	
}
	
	
	
	
	/*
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	@RequestMapping("/hi")
	public String hi(@RequestParam(name="firstname",required=falsee, defaultValue="stranger") String firstName) {
			return "Hi " + firstName;
			}
	@RequestMapping("/about")
	public String about() {
		return "This is the about page";
	}
	*/
	
	

