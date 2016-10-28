package Strings;

import java.util.Arrays;


//https://www.careercup.com/question?id=5659201272545280
//@author Tanvir
public class OrderingString {

	public static boolean isInOrder(String input,String order){
		if(input==null || input.length()==0 || order.length()==0) return true;
		
		int[] tracker = new int[256];
		Arrays.fill(tracker,0);
		
		int orderPtr = -1;
		char current=input.charAt(0);
		
		for(char ch: input.toCharArray()){
			if( orderPtr<order.length()-1 && ch == order.charAt(orderPtr+1)){
				if(orderPtr>=0) tracker[order.charAt(orderPtr)] =1;
				current = ch;	
				orderPtr= orderPtr+1;
			}
			if(ch!=current && tracker[ch] ==1 ) return false;
		}
		return true;
	}
	
	public static void main(String arg[]){
		System.out.println(OrderingString.isInOrder("hello world", "hr"));
		System.out.println(OrderingString.isInOrder("costco is great", "ctg"));
		System.out.println(OrderingString.isInOrder("c", "c"));
	}
}
