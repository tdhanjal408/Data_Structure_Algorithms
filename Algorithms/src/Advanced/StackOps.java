package Advanced;

import java.util.ArrayList;
import java.util.List;

public class StackOps<E> {
	private int capacity;
	private List<E> container;
	private int top;
	
	public StackOps(int capacity){
		this.capacity = capacity;
		container = new ArrayList<E>();
		top=-1;
	}
	
	public void push(E value){
		if(top == capacity-1) {
			System.out.println("Stack is full!!!");
			return;
		}
		container.add(++top, value);
	}
	
	public E pop(){ 
		if(top == -1){
			System.out.println("Empty Stack!!");
			return null;
		}
		E value = container.get(top);
		container.remove(top);
		top--;
		return value;
	}
	
	public boolean isEmpty(){
		if(top == -1) return true;
		return false;
	}
	
	public int getSize(){
		return top+1;
	}
	
}
