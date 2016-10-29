package Strings;

import java.util.ArrayList;
import java.util.List;

// https://www.careercup.com/question?id=5758190080753664
// @ Author Tanvir

public class DelimiterString {

	public static List<String> getDimitedOutput(String s){
		if(s==null || s.length() ==0) return null;
		
		int index =0;
		boolean haveParent = false;
		char lastDelimiter = ' ';
		
		List<String> list =new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		
		for(char ch:s.toCharArray()){
			
			if(ch=='{' || ch=='(' || ch=='[' || ch=='}'|| ch==')'|| ch==']'){
				if(s.length()-1>index && s.charAt(index+1) == ch) {
					sb.append(ch);
					index= index+2;
					continue;
				}
				if(ch=='{' && lastDelimiter=='(') {
					haveParent = true;
					sb.append(ch);
					index++;
					continue;
				}
				if(ch=='}' && haveParent){
					sb.append(ch);
					index++;
					continue;
				}
					
				lastDelimiter= ch;
				haveParent= false;
				list.add(sb.toString());
				sb = new StringBuilder();
				index++;
				continue;
			}
			sb.append(ch);
			index++;
		}
		
		if(sb.toString().length()!=0) list.add(sb.toString());
		return list;
	}
	public static void main(String[] args) {
		List<String> result = DelimiterString.getDimitedOutput("abc((g{h}j)ujj");
		System.out.println(result.toString());

	}

}
