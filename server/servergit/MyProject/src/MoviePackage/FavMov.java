package MoviePackage;
import java.util.Scanner;

public class FavMov {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Movie favMov = new Movie();
		System.out.println("Enter fav mov name: ");
		favMov.setName(input.nextLine());
		System.out.println("Enter fav mov rating: ");
		favMov.setRating(input.nextLine());
		System.out.println("Enter fav mov year: ");
		favMov.setYear(Integer.parseInt(input.nextLine()));
		System.out.println("Enter fav mov runtime: ");
		favMov.setRuntime(Integer.parseInt(input.nextLine()));
		
		String result= favMov.toString();
		System.out.println(result);
		input.close();
		
		
		
		
		
		
	}

}
