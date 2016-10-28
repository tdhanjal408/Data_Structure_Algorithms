package Strings;

//https://www.careercup.com/question?id=5641948569272320
//@author Tanvir
import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
	public static boolean checkPalindromePermutation(String str){
		if(str == null || str.length() ==0) return false;
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(char ch: str.toCharArray()){
			if(map.containsKey(ch)){
				map.put(ch, map.get(ch) +1);
			}else{
				map.put(ch, 1);
			}
		}
		int singleCount =0;
		for(Map.Entry<Character,Integer> entry: map.entrySet()){
			if(entry.getValue()%2==1) singleCount++;
			if(singleCount==2) return false;
		}
		
		return true;
	}
	
	public static void main(String args[]){
		System.out.println(PalindromePermutation.checkPalindromePermutation("aaabgh"));
		System.out.println(PalindromePermutation.checkPalindromePermutation("a"));
		System.out.println(PalindromePermutation.checkPalindromePermutation("ccbdb"));
	}
}
