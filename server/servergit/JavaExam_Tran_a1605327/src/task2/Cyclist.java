package task2;

public class Cyclist {
	String name;
	double weight;
	double climbingPower;
	public Cyclist(String name, double weight, double climbingPower) {
		this.name = name;
		this.weight = weight;
		this.climbingPower = climbingPower;
	}
	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public double getClimbingPower() {
		return climbingPower;
	}
	public double getWattsPerKilo(double climbingPower, double weight) {
		double wattsPerKilo = climbingPower/weight;
		return wattsPerKilo;
	}
	
	
}
