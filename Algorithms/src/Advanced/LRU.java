package Advanced;

import java.util.HashMap;

public class LRU {
	private class Node{
		int key;
		int val;
		Node next;
		Node pre;
		
		Node(int key,int val){
			this.key = key;
			this.val = val;
		}
	}
	
	private int capacity;
	private HashMap<Integer,Node> map;
	private Node head = null;
	private Node tail = null;
	
	public LRU(int cap){
		capacity = cap;
		map = new HashMap<Integer,Node>();
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			Node old = map.get(key);
			remove(old);
			setHead(old);
			return old.val;
		}
		return -1;
	}
	
	
	public void put(int key,int val){
		if(map.containsKey(key)){
			Node old = map.get(key);
			old.val= val;
			remove(old);
			setHead(old);
		}
		else{
			Node newNode = new Node(key,val);
			if(map.size()== capacity){
				map.remove(tail.key);
				remove(tail);
			}
			setHead(newNode);
			map.put(key, newNode);
		}
		
	}
	
	public void setHead(Node node){
		node.next = head;
		node.pre = null;
		
		if(head!=null) head.pre=node;
		head = node;
		if(tail == null) tail = head;
	}
	
	public void remove(Node node){
		if(node.pre!=null) {
			node.pre.next = node.next;
		}else{
			head = node.next;
		}
		
		if(node.next!=null){
			node.next.pre = node.pre;
		}else{
			tail = node.pre;
		}
	}
	
	
	public static void main(String args[]){
		LRU lru = new LRU(3);
		lru.put(1, 30);
		lru.put(2, 35);
		lru.put(3, 40);
		lru.put(4, 45);
		System.out.println(lru.get(2));
		lru.put(6, 50);
		System.out.println(lru.get(3));
	}
	
}
