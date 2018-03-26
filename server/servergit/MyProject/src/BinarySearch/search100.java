package BinarySearch;
import java.util.Scanner;

public class search100 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	System.out.println("enter min: ");
	int min = Integer.parseInt(input.nextLine());
	System.out.println("enter max: ");
	int max = Integer.parseInt(input.nextLine());
	System.out.println("enter input: ");
	int inputNum = Integer.parseInt(input.nextLine());

	int guess = 0;
	
	while (guess!=inputNum) {
		guess=(min+max)/2;
	
		if(guess<inputNum) {
			min=guess;
		}
		else if(guess>inputNum) {
			max=guess;
		}
	}
	System.out.println("Guess=" +guess);
	
	}}
	
	