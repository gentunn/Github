package WordPair;
import java.util.ArrayList;
import java.util.Scanner;

public class ObjectsWordPairProgram {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		  ArrayList<wordPair> words = new ArrayList<wordPair>();
		   String inputDictEng="";
		   String inputDictFin="";
		   wordPair inputEngFin = new wordPair("","");
		   
		   System.out.println("=== Creating an English-Finnish dictionary (ok ends) ===");
		   while (!"ok".equals(inputDictEng)) {
			   System.out.print("Enter an English  word (ok ends): ");
			   inputDictEng=input.nextLine();
			   if(!"ok".equals(inputDictEng)) {
			   System.out.print("Enter a Finnish  word: ");
			   inputDictFin=input.nextLine();
			   words.add(new wordPair(inputDictEng,inputDictFin)); 
			   /* cant make object inputEngFin, set Eng and Fin words to it then add it to words,
			    * because it will add the same object(inputEngFin) over and over(the words list just cannot get to second element)
			    * just like how you cant add the same bank account multiple times and expect it to be recognized as multiple accounts
			    * solution : create an entire new wordPair object and assign variables to it
			    */
			   }
			   
			   }
		   
		   String inputTranslate="";
		   String outputTranslate="";
		   
		   System.out.println("=== English-Finnish translation service (quit ends) ===");
		   while(!"quit".equals(inputTranslate)){
			   boolean translated = false;
			   System.out.println("Enter an English word: ");
			   inputTranslate = input.nextLine();
			   if(!"quit".equals(inputTranslate)) {
			   for (int i=0;i<words.size() && !translated;i++) {
				   String dummyEng = words.get(i).getEnglishWord();
				   String dummyFin = words.get(i).getFinnishWord();
				   if(inputTranslate.equals(dummyEng)) {
					   outputTranslate = dummyFin;
					   translated = true;
				   } 
			   }
			   if (translated) {
				   System.out.println(outputTranslate);
				   }
			   else {
					   System.out.println("Unknown word");
			   }
			   System.out.println();
			   }
			   else {
				   System.out.println("Bye!");
			   }
		   }
		   	   
	}
}
