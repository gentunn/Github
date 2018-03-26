package database.haagahelia.databaseStudentRegister.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import database.haagahelia.databaseStudentRegister.domain.Student;
import database.haagahelia.databaseStudentRegister.domain.StudentRepository;

@Controller
public class StudentController {
	@Autowired
	StudentRepository repository;
	
	
 @RequestMapping("/student")
 public String students(Model model) {
	 model.addAttribute("students", repository.findAll());
	 return "student"; 
 }
 @RequestMapping("/delete/{id}")
 public String deleteStudent(@PathVariable("id") Long studentid, Model model) {
	 repository.delete(studentid);
	 return "redirect:../student";
	 
 }
 @RequestMapping("/add")
 public String addStudent(Model model) {
	 model.addAttribute("student", new Student());
	 return "addStudent";
	 
 }
 
 @RequestMapping(value = "/save", method = RequestMethod.POST)
 public String saveStudent(Student student) {
	 repository.save(student);
	 return "redirect:student";
	 
 }

	 
 
 
}
