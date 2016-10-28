package Strings;

//http://www.geeksforgeeks.org/count-pairs-of-consecutive-zeros/
// 0->10
// 1->01
//01 -> 1001 -> 01101001 -> 1001011001101001 ->
public class ConsecutiveZero {
	public static int zeroPairCount(int n){
		if(n==1) return 0;
		if(n==2 || n ==3) return 1;
		n = (int) (Math.pow(2, n));
		n=n/12;
		return 2*n + 1;
 	}
	
	public static void main(String args[]){
		System.out.println( ConsecutiveZero.zeroPairCount(6));
	}
}
