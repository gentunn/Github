package test1;


public class ArrayProgram {

	public static void main(String[] args) {
		ArrayFun arrayFun = new ArrayFun();
		int[] a1 = {1,5,3,4};
		int[] a2 = {1,2,3,10,5,4};
		int[] a3 = {5,5,1,1,1,1};

		System.out.println(arrayFun.check(a1,a2));
		System.out.println(arrayFun.check(a2,a1));
		System.out.println(arrayFun.check(a3,a1));

	}

}
