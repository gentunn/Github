package test3;
import java.util.Scanner;
public class PasswordProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("=== Password Validation ===");
		System.out.print("Enter username: ");
		String username = input.nextLine();
		System.out.print("Enter password: ");
		
		String password = input.nextLine();
			if(username.isEmpty() || password.isEmpty()){
				System.out.println("Incomplete input.");
			}
			else {
				boolean validated = validatePassword(username,password);
				if(validated) {
					System.out.println("Password ok!");
				}
				else {
					System.out.println("Invalid password.");
				}
			}
 
		}

	


	private static boolean validatePassword(String username, String password) {
		boolean validate = false;
		boolean include = false;
		boolean length = false;
		boolean upper = false;
		boolean lower = false;
		int countUpper=0;
		int countLower=0;
		
		if(password.toLowerCase().indexOf(username.toLowerCase())==-1) {
			include = true;
		}
		if(password.length()>=5){
			length = true;
		}
		for(int i=0;i<password.length();i++){
			if(Character.isUpperCase(password.charAt(i))){
				countUpper++;
			}
		}
		if(countUpper>=1){
			upper=true;
		}
		for(int i=0;i<password.length();i++){
			if(Character.isLowerCase(password.charAt(i))){
				countLower++;
			}
		}
		if(countLower>=1){
			lower=true;
		}
		
		
		if (include && length && upper && lower ){
			validate = true;
		}
		else{
			validate = false;
		}
				return validate;
	}
	

	}


