package Advanced;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// http://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/

public class HashArray<E> {
	private Map<E,Integer> map;
	private List<E> list;
	private int size;
	
	public HashArray(){
		list = new ArrayList<E>();
		map = new HashMap<E,Integer>();
		size = -1;
	}
	
	public void insert(E value){
		if(map.containsKey(value)) return;
		list.add(value);
		size++;
		map.put(value,size);
	}
	
	public void remove(E value){
		if(!map.containsKey(value)) return;
		int index = map.get(value);
		E temp = list.get(size);
		list.remove(size);
		size--;
		list.add(index,temp);
		map.remove(value);
		map.put(temp, index);
	}
	
	public int search(E value){
		if(!map.containsKey(value)) return -1;
		return map.get(value);
	} 
	
	public E getRandom(){
		Random rand = new Random();
		int  index = rand.nextInt(size) + 0;
		return list.get(index);
	}
}
