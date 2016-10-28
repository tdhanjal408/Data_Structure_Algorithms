package Strings;

//http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
import java.util.HashSet;
import java.util.Set;

public class WordBreakPorblem {

	public static boolean canSegmented(String s,Set<String> set){
		if(s==null || s.length() == 0 ) return true;
		boolean success= false;;
		for(int i = 0 ; i < s.length();i++){
			if(set.contains(s.substring(0,i+1))){
				success= true;
				if(i<s.length()){  
					success = canSegmented(s.substring(i+1),set);
				}
				if(success) return true;	
			}
		}
		return success;
	}
	
	public static void main(String args[]){
		Set<String> set = new HashSet<String>();
		set.add("leet");
		set.add("co");
		set.add("cod");
		set.add("e");
		System.out.println(WordBreakPorblem.canSegmented("leetcode",set));
	}
}
