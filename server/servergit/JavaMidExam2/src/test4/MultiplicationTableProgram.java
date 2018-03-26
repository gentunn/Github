package test4;
import java.util.Scanner;
public class MultiplicationTableProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("=== Multiplication Table ===");
		try{
		System.out.println("Enter a number: ");
		int number= Integer.parseInt(input.nextLine());
		
		/////////// First Line
		System.out.print("*");
		for(int i = 1; i<=number;i++){
			System.out.printf("%4d",i);
		}
		System.out.println("");
		
		/////// the rest
		for (int i = 1; i<=number;i++) {
			System.out.print(i);
			for(int a = 1; a<=number;a++){
				System.out.printf("%4d",i*a);
			}
			System.out.println("");
		}
		input.close();
		}
		catch(Exception e){
			System.out.println("Invalid input.");
		}
	}

}
