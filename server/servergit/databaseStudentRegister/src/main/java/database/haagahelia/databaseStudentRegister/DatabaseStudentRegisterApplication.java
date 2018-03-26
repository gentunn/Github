package database.haagahelia.databaseStudentRegister;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import database.haagahelia.databaseStudentRegister.domain.Student;
import database.haagahelia.databaseStudentRegister.domain.StudentRepository;

@SpringBootApplication
public class DatabaseStudentRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseStudentRegisterApplication.class, args);
	}
		@Bean public CommandLineRunner demo(StudentRepository repository) {
			return (args) -> {
					Student s1= new Student("June", "May", "ju.m@mail.com");
					Student s2= new Student("Juniper", "Wood", "ju.w@mail.com");
					Student s3= new Student("Tom", "Hanks", "to.h@mail.com");
					
					repository.save(s1);
					repository.save(s2);
					repository.save(s3);
				};
		}
		
	
}
