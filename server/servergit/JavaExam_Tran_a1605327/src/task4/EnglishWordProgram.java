package task4;
import java.util.Scanner;
public class EnglishWordProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an English word: ");
		String englishInput = input.nextLine();
		if (englishInput.isEmpty()) {
			System.out.println("No word given.");
		}
		else {
			if (englishInput.matches("[ÅÅÄÖåäö]{1,}") ) {
				System.out.println("'"+englishInput+"'"+" is not an English word.");
			}
		
			else {
				System.out.println("'"+englishInput+"'"+" might be an  English word.");
			}
		}
	}
}


