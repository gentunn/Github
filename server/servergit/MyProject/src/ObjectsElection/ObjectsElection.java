package ObjectsElection;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjectsElection {
	public static void main(String args[]) {
	   Scanner input = new Scanner(System.in);
       System.out.print("Enter the number of candidates: ");
	   int candidateNum = Integer.parseInt(input.nextLine());
	   Candidate[] candidateArray = new Candidate[candidateNum];
	   for (int i=0; i<candidateNum;i++) {
		   System.out.print("Enter "+i+". name: ");
		   String nameInput = input.nextLine();
		   System.out.print("Enter votes: ");
		   int voteInput = Integer.parseInt(input.nextLine());
		   candidateArray[i]=new Candidate(nameInput);
		   candidateArray[i].setVotes(voteInput); 
	   }
	   Candidate winner = candidateArray[0];
	   for (int i=0; i<candidateNum-1;i++) {
		   if(candidateArray[i].getVotes()<candidateArray[i+1].getVotes()) {
			   winner = candidateArray[i+1];
		   }
	   }
	   
	   
	   
	   }}
	   
	   
	   /*
	
	   String[] candidateName = new String[candidateNum];
	   int[] candidateVote = new int[candidateNum];
	   int[] winnerArray = new int[candidateNum];
	  
      // for x number of candidates, ask for name and vote x times //
	   
	   for (int i=1; i<=candidateNum;i++) {
		   System.out.print("Enter "+i+". name: ");
		   String nameInput = input.nextLine();
		   System.out.print("Enter votes: ");
		   int voteInput = Integer.parseInt(input.nextLine());

		   candidateName[i-1] = nameInput;
		   candidateVote[i-1] = voteInput;	   
		   winnerArray[i-1] = candidateVote[i-1];   
		   }
	  
	   // push candidateVote's values in to winnerArray, sort winnerArray //
	   
	   Arrays.sort(winnerArray);
	   
	   
	   // if winnerArray[i] = candidateVote[i], print the corresponding candidateVote and candidateName // 
	   int count = 0;
	   for (int i=1; i<=candidateNum; i++) {
    	   if (candidateVote[i-1]==winnerArray[winnerArray.length-1]) {
    		   count++;
    	   }
       }
	   if (count==1) {
		   for (int i=1; i<=candidateNum; i++) {
	    	   if (candidateVote[i-1]==winnerArray[winnerArray.length-1]) {
	    		   System.out.println("The winner is "+candidateName[i-1]+" with "+candidateVote[i-1]+" votes!");
	    	   }
	   }
	   }
	   else {
		   System.out.println("The election is a tie between the following candidates: ");
		   for (int i=1; i<=candidateNum; i++) {
	    	   if (candidateVote[i-1]==winnerArray[winnerArray.length-1]) {
	    		   System.out.println(candidateName[i-1]+" ("+candidateVote[i-1]+" votes)");
	    	   }
	   }
	   }
	  
	   }
	   catch (Exception e) {
		   System.out.println("Invalid input");
	   }


	   
	   

	}

}
*/
	   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
	

