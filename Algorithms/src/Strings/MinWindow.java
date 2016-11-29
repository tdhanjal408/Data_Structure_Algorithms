package Strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


//http://www.programcreek.com/2014/05/leetcode-minimum-window-substring-java/
//For example, S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
public class MinWindow {

	public static String minWindowSubString(String s, String t){
		if(s.length()<t.length()) return " ";
		Map<Character,Integer> tMap = new HashMap<Character,Integer>();
		Map<Character,Integer> sMap = new HashMap<Character,Integer>();
		Queue<Integer> que = new LinkedList<Integer>();
		
		for(char ch:t.toCharArray()){
			if(tMap.containsKey(ch)){
				tMap.put(ch,tMap.get(ch)+1);
			}else{
				tMap.put(ch,1);
			}
		}
		
		int start =0;
		String output = s.concat(t);
	
		for(int i=0;i<s.length();i++){
			System.out.println("sMap" + sMap);
			if(tMap.containsKey(s.charAt(i))){
				que.add(i);
				if(sMap.containsKey(s.charAt(i))){
					sMap.put(s.charAt(i),sMap.get(s.charAt(i))+1);
				}else{
					sMap.put(s.charAt(i),1);
				}
			}
			
			if(sMap.equals(tMap)){
				if(s.substring(start,i).length()<output.length()){
					output=s.substring(start,i+1);
				}
				sMap.put(s.charAt(start),sMap.get(s.charAt(start))-1);
				System.out.println("i" + i);
				if(!que.isEmpty() && i!=s.length()-1){
					que.poll();
					start = que.peek();
					System.out.println("start" + start);
				}
				
			}
			if(sMap.containsKey(s.charAt(i)) && sMap.get(s.charAt(i)) > tMap.get(s.charAt(i))){
				
				int index = que.poll();
				while(s.charAt(i)!=s.charAt(index)){
					if(sMap.containsKey(s.charAt(index)))sMap.put(s.charAt(index),sMap.get(s.charAt(index))-1);
					index = que.poll();
				}
				sMap.put(s.charAt(index),sMap.get(s.charAt(index))-1);
				start = que.peek();
			}
		}
		
		return (output.length()==(s.length()+t.length()))? " " : output;
	}

	public static void main(String[] args) {
		System.out.println(MinWindow.minWindowSubString("arrtjlkat","at"));

	}

}
