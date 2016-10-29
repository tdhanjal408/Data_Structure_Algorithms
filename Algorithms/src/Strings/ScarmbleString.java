package Strings;

// https://www.careercup.com/question?id=5662443448565760
// @Author Tanvir
public class ScarmbleString {
	public static String getScrambledString(String s){
		if(s== null || s.length() == 0){
			return null;
		}
		
		StringBuilder sb = new StringBuilder();
		int count =0;
		char prev = s.charAt(0);
		for(char ch : s.toCharArray()){
			if(prev != ch){
				sb.append(prev);
				sb.append(count);
				count =0;
			}
			count++;
			prev = ch;
		}
		
		sb.append(prev);
		sb.append(count);
		
		return sb.toString();
	}
	
	public static void main(String args[]){
		System.out.println(getScrambledString("aaaabbbaa"));
		System.out.println(getScrambledString("a"));
		System.out.println(getScrambledString("abjjit"));
	}
	
}
