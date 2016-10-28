package Strings;

public class GenericString {

	//http://www.programcreek.com/2014/05/leetcode-length-of-last-word-java/
	public static int getLastwordLength(String s){
		if(s==null || s.length()==0) return 0;
		
		boolean flag=false;
		int result=0;
		for(int i = s.length()-1;i>0;i++){
			char ch = s.charAt(i);
			if((ch>'a' && ch<'z') ||(ch>'A' && ch<'Z')){
				flag = true;
				result++;
			}else{
				if(flag) return result;
			} 
			
		}
		return 0;
	}
	
	//http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
	
}
