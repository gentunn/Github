package Applicants;

public class Applicant {
		private String name;
		private int points;
		
	public Applicant(String name,int points) {
		this.name = name;
		this.points= points;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getPoints() {
		return points;
	}
	
	public  String toString() {
		return name + " , " + points + " points"
	}
