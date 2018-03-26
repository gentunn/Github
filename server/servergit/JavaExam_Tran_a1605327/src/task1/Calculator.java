package task1;
import java.util.ArrayList;

public class Calculator {





	public double avg(int[] numArray){
		double dummy = 0;
		double result = 0;
		 for (int i = 0; i<numArray.length;i++){
			 dummy += numArray[i];
		 }
		 result= dummy/numArray.length;
		 return result;
	}
	
	public int max(int[] numArray) {
		int dummy = numArray[0];
		for (int i=0;i<numArray.length;i++) {
			if(dummy<numArray[i]) {
				dummy=numArray[i];
			}
		}
		return dummy;
	}




	
       
}
