package A;
import java.util.Scanner;
public class aB {

	public static void main(String args[]) {
		
		   Scanner input = new Scanner(System.in);
			System.out.print("Enter a string: ");
			String textInput = input.nextLine();
			String textOutput = reverse(textInput);
			System.out.println(textOutput);

			
	}
// convert string to array of characters, invert array, convert back to string // 
private static String reverse(String text) {
	
	for(int i =0; i<text.length()/2;i++) {
		char a = text.charAt(i);
		char z = text.charAt(text.length()-1-i);
		
	}
}
}
