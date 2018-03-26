package task3;
import java.util.Scanner;


public class StringPrintingProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String words = input.nextLine();
		if (words.isEmpty()) {
			System.out.println("No input given.");
		}
		else {
			for (int i=0; i<words.length();i++) {
				System.out.println(words.substring(0, i+1));
			}
			
		}
		input.close();
	}

}
