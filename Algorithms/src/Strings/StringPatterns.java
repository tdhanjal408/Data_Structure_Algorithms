package Strings;

import java.util.ArrayList;
import java.util.List;

/*
http://www.geeksforgeeks.org/find-all-strings-that-match-specific-pattern-in-a-dictionary/
Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "foo"
Output: [xyy abb]
Explanation: 
xyy and abb have same character at index 1 and 2 like the pattern
*/

public class StringPatterns {
	public static List<String> getCommonPatterns(String pattern,List<String> dic ){
		if (dic == null || dic.size() ==0 || pattern == null || pattern.length() == 0 ) return null;
		
		// first step is to generate the pattern and then loop over list to find similar one.
		StringBuilder sb = new StringBuilder();
		int ptr=0;
		char prev = pattern.charAt(0);
		
		for(char ch: pattern.toCharArray()){
			if(ch != prev){
				sb.append(ptr);
				prev= ch;
				ptr=0;
			}
			ptr++;
		}
		sb.append(ptr);
		System.out.println("Pattern :"+sb.toString());
		
		List<String> response = new ArrayList<String>();
		
		for(String s:dic){
			if(sb.toString().equalsIgnoreCase(checkPattern(s,sb.toString()))){
				response.add(s);
				System.out.println("Pattern ok :"+s);
			}
		}
		
		return response;
	}
	
	public static String checkPattern(String s,String pattern){
		StringBuilder sb = new StringBuilder();
		int ptr=0;
		int index=0;
		char prev = s.charAt(0);
		
		for(char ch: s.toCharArray()){
			if(ch != prev){
				sb.append(ptr);
				if(pattern.charAt(index)!= String.valueOf(ptr).charAt(0)) return null;
				prev= ch;
				ptr=0;
			}
			ptr++;
		}
	
		sb.append(ptr);
		return sb.toString();
	}
	
	public static void main(String args[]){
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("bu");
		list.add("daa");
		StringPatterns.getCommonPatterns("abc", list);
	}
	
}
