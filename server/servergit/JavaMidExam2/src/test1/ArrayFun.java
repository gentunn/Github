package test1;

public class ArrayFun {
    public boolean check(int[] a,int[] b) {
    	boolean check = false;
    	int count =0;
    	for (int i=0; i<a.length; i++){
    		for (int e=0; e<b.length; e++){
    			if(a[i]==b[e]) {
    				count++;
    			}
    		}
    	}
    	if(count==a.length) {
    		check =true;
    	}
    	else{
    		check=false;
    	}
    
    	return check;
    }
}
