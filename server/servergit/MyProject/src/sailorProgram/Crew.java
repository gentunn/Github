package sailorProgram;
import java.util.ArrayList;
public class Crew {
     private ArrayList<Sailor> sailorList;
     
 public Crew() {
		this.sailorList = new ArrayList<Sailor>();
		// constructor determine what appen when create a new sailorList
	}

public void addCrewMember (Sailor sailor) {
	 sailorList.add(sailor);
 }

public String toString() {
	String dummyString = "";
	for(int i=0;i<sailorList.size();i++) {
		dummyString += sailorList.get(i).toString() + "\n";
	}
		return dummyString;
	}
	
	
	
}
 


