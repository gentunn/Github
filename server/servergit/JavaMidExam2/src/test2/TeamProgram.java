package test2;
import java.util.Scanner;
import java.util.ArrayList;

public class TeamProgram {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("=== Enter teams (empty team name ends) ===");
		ArrayList<Team> teamList = new ArrayList<Team>();
		boolean quit = false;
		
		//////// Entering team info 
		while(!quit) {
			System.out.println("Enter team name: ");
			String name = input.nextLine();
			if (name.isEmpty()){
				quit=true;
				break;
			}
			else {
				System.out.println("Enter country: ");
				String country = input.nextLine();
				System.out.println("Enter wins: ");
				int wins = Integer.parseInt(input.nextLine());
				Team toAdd = new Team(name,country,wins);
				teamList.add(toAdd);
			}
		}
		
		///////// Reverse
		System.out.println("=== All teams ===");
			for (int i = teamList.size()-1; i>=0; i--) {
				System.out.println(teamList.get(i).getName() 
						+ " (" + teamList.get(i).getCountry()
						+"): "+teamList.get(i).getWins()+" wins" );
			}
	    ///////// Search
			System.out.println("=== Search team by country ===");
			System.out.println("Enter country: ");
			String countrySearch = input.nextLine();
			ArrayList<Team> teamSearch = new ArrayList<Team>();
			for(Team a : teamList){
				if(countrySearch.toLowerCase().equals(a.getCountry().toLowerCase())){
					teamSearch.add(a);
				}
			}
			if(teamSearch.size()==0){
				System.out.println("There are no teams from this country.");
			}
			else{
			for(Team b: teamSearch){
				System.out.println(b.getName() 
						+" ("+b.getWins()+" wins)" );
			}
			}
	input.close();
	}
}	