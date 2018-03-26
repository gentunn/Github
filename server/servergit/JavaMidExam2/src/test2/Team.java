package test2;

public class Team {
	private String name;
	private String country;
	private int wins;
	public Team(String name, String country, int wins) {
		this.name = name;
		this.country = country;
		this.wins = wins;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getWins() {
		return wins;
	}
	public void setWins(int wins) {
		this.wins = wins;
	}
	
}


