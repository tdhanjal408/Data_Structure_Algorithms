package Advanced;

import java.util.ArrayList;
import java.util.List;

public class QueueOps<E> {
	private List<E> list;
	private int capacity,head,tail;
	
	public QueueOps(int capacity){
		list = new ArrayList<E>();
		this.capacity = capacity;
		head = -1;
		tail = -1;
	}
	
	public void enQueue(E value){
		if((tail+1)%capacity== head){
			System.out.println("Queue is full!!!");
			return;
		}else if(isEmpty()){
			head++;
			tail++;
			list.add(tail,value);
		}
		else{
			tail = (tail+1)%capacity;
			list.add(tail,value);
		}
	}
	
	public E  deQueue(){
		E value = null;
		if(isEmpty()){
			System.out.println("Queue is Empty!!!");
		}else if(head == tail){
			value = list.get(head);
			list.remove(head);
			head =-1;
			tail=-1;
		}else{
			value = list.get(head);
			list.remove(head);
			head = (head+1)%capacity;
		}
		return value;
	}
	
	public boolean isEmpty(){
		if(head ==-1 && tail ==-1){
			return true;
		}
		return false;
	}
}


