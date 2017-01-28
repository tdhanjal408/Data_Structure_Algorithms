package Strings;

import java.util.*;

public class Anagram {
	
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    ArrayList<ArrayList<Integer>> out = new ArrayList<ArrayList<Integer>>();
	    if(a==null || a.size()==0) return out;
	    
	    Map<Map<Character,Integer>,Integer> indexMap = new HashMap<Map<Character,Integer>, Integer>();
	    Map<Character,Integer> charMap = null;
	    
	    int ptr=1;
	    for(String s: a){
	    	charMap=new HashMap<Character, Integer>();
	    	for(char ch:s.toCharArray()){
	    		if(charMap.containsKey(ch)){
	    			charMap.put(ch,charMap.get(ch)+1);
	    		}else{
	    			charMap.put(ch,1);
	    		}
	    	}
	    	
	    	if(indexMap.containsKey(charMap)){
	    		ArrayList<Integer> list= null;
	    		list= out.get(indexMap.get(charMap));
	    		list.add(ptr);	    		
	    	}else{
	    		indexMap.put(charMap,out.size());
	    		ArrayList<Integer> list=new ArrayList<Integer>();
	    		list.add(ptr);
	    		out.add(out.size(),list);
	    	}
	    	
	    	ptr++;
	    }
	    	
	    
	    return out;
	}

	public static void main(String[] args) {
		Anagram a = new Anagram();
		String[] str = { "abbbaabbbabbbbabababbbbbbbaabaaabbaaababbabbabbaababbbaaabbabaabbaabbabbbbbababbbababbbbaabababba", "abaaabbbabaaabbbbabaabbabaaaababbbbabbbaaaabaababbbbaaaabbbaaaabaabbaaabbaabaaabbabbaaaababbabbaa", "babbabbaaabbbbabaaaabaabaabbbabaabaaabbbbbbabbabababbbabaabaabbaabaabaabbaabbbabaabbbabaaaabbbbab", "bbbabaaabaaaaabaabaaaaaaabbabaaaabbababbabbabbaabbabaaabaabbbabbaabaabaabaaaabbabbabaaababbaababb", "abbbbbbbbbbbbabaabbbbabababaabaabbbababbabbabaaaabaabbabbaaabbaaaabbaabbbbbaaaabaaaaababababaabab", "aabbbbaaabbaabbbbabbbbbaabbababbbbababbbabaabbbbbbababaaaabbbabaabbbbabbbababbbaaabbabaaaabaaaaba", "abbaaababbbabbbbabababbbababbbaaaaabbbbbbaaaabbaaabbbbbbabbabbabbaabbbbaabaabbababbbaabbbaababbaa", "aabaaabaaaaaabbbbaabbabaaaabbaababaaabbabbaaaaababaaabaabbbabbababaabababbaabaababbaabbabbbaaabbb"};
		List<String> list = new ArrayList<String>(Arrays.asList(str));
		System.out.print(a.anagrams(list));
	}

}
