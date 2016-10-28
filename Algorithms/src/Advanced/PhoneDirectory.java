package Advanced;

import java.util.HashMap;
import java.util.Map;

// http://www.geeksforgeeks.org/implement-a-phone-directory/

// @author Tanvir

public class PhoneDirectory {

	private class TrieNode{
		HashMap<Character,TrieNode> children;
		boolean endOfWord;
		
		public TrieNode(){
			children= new HashMap<>();
			endOfWord = false;
		}
		
	}
	
	private final TrieNode root;
	
	public PhoneDirectory(){
		root= new TrieNode();
	}
	
	public void insert(String str){
		TrieNode curr = root;
		for(char ch : str.toCharArray()){
			TrieNode currNode = curr.children.get(ch);
			if(currNode!=null){
				curr= currNode;
			}
			else{
				TrieNode child = new TrieNode();
				curr.children.put(ch, child);
				curr = child;
			}
		}
		
		curr.endOfWord = true;
	}
	
	public void searchPrefix(String str){
		TrieNode curr = root;
		for(char ch : str.toCharArray()){
			TrieNode currNode = curr.children.get(ch);
			if(currNode==null){
				System.out.println("No result found");
				return ;
			} curr=currNode;
		}
		
		displayResult(curr,str);
	}
	
	public void displayResult(TrieNode curr,String prefix){
		if(curr.endOfWord)
			System.out.println("->" + prefix);
		
		for (Map.Entry<Character,TrieNode> entry : curr.children.entrySet()) {
			displayResult(entry.getValue(),prefix+ entry.getKey());
		}
	}
	
	public static void main(String args[]){
		PhoneDirectory phoneDirectory = new PhoneDirectory();
		phoneDirectory.insert("great");
		phoneDirectory.insert("grapes");
		phoneDirectory.insert("gr");
		phoneDirectory.insert("green");
		System.out.println("<-Dictionary Created->");
		phoneDirectory.searchPrefix("grap");
	}
}
