package com.bookstore.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;





@Controller
///@ResponseBody will only return a string (index)

public class BookController {
	@RequestMapping(value="/hello")
	public String hello() {
	return "Not a get";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String message(Model model) {
	String messageString = "Bookstore running";
	model.addAttribute("message",messageString);
	return "index";
	}
	
}
