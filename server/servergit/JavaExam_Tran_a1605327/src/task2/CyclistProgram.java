package task2;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Arrays;
public class CyclistProgram {
//This is task 2a

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat twoDecimals = new DecimalFormat("0.00");
		DecimalFormat noDecimals = new DecimalFormat("0");
		ArrayList<Cyclist> cyclistList = new ArrayList<Cyclist>();
		Scanner input = new Scanner(System.in);
		boolean quit = false;
		String nameInput = "";
		double weightInput = 0;
		double climbingPowerInput = 0;
		while (!quit) {
		System.out.print("Enter name: ");
		nameInput = input.nextLine();
			if(!nameInput.isEmpty()) {
				System.out.print("Enter weight: ");
				weightInput = Integer.parseInt(input.nextLine());
				System.out.print("Enter climbing power: ");
				climbingPowerInput = Integer.parseInt(input.nextLine());
				Cyclist newCyclist = new Cyclist(nameInput,weightInput,climbingPowerInput);
				cyclistList.add(newCyclist);
			}
			else {
			quit = true;
			System.out.println("Bye!");
			}
			
		}
		System.out.println(" === Cyclists === ");
		for(int i = 0; i<cyclistList.size();i++) {
			System.out.println(cyclistList.get(i).getName() 
					+ ": " + noDecimals.format(cyclistList.get(i).getWeight()) 
					+ "kg, " + noDecimals.format(cyclistList.get(i).getClimbingPower())
					+"W, ("+  twoDecimals.format(cyclistList.get(i).getWattsPerKilo(cyclistList.get(i).getClimbingPower(), cyclistList.get(i).getWeight())).replace(",", ".")+ " W/kg)");
		}
		////////////////////////////////////// 2b 
		double[] compare = new double[cyclistList.size()];
		for(int i = 0; i<compare.length;i++) {
			compare[i] = cyclistList.get(i).getWattsPerKilo(cyclistList.get(i).getClimbingPower(), cyclistList.get(i).getWeight());
		}
		Arrays.sort(compare);
	
		
		for(int i = 0; i<compare.length;i++) {
			if(compare[compare.length-1] == cyclistList.get(i).getWattsPerKilo(cyclistList.get(i).getClimbingPower(), cyclistList.get(i).getWeight())) {
				   System.out.print(cyclistList.get(i).getName());
			}
		}
		System.out.print("("+ twoDecimals.format(compare[compare.length-1])+"W/kg)");
		input.close();
}
}

