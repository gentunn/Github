package fi.haagahelia.hellothyme.web;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.hellothyme.domain.Student;



@Controller
public class ThymeController  {
	
	/*@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello(Model model) {
	model.addAttribute("message", new Message());
	return "hello";
	}	*/
	/////////////////////////
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String greeting(@RequestParam(value="name") String name,
						   @RequestParam(value="age") String age, Model model) {
	model.addAttribute("name", name);
	model.addAttribute("age", age);
	return "hello";
	}
	//////////////////////
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String form(Model model) {
	ArrayList<Student> studentList= new ArrayList<Student>();
	studentList.add(new Student("Susan","Boyle","sb@mail.com"));
	studentList.add(new Student("Simon","Cowell","cw@mail.com"));
	studentList.add(new Student("Katie","Perry","kp@mail.com"));
	model.addAttribute("students",studentList);
	
	return "student";
	}
	/*
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String listForm(Model model) {
		
	}
	*/
	
	
}
