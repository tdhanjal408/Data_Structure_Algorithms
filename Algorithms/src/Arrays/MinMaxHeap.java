package Arrays;

import java.util.Arrays;

public class MinMaxHeap extends Thread{
	private int heapSize =0;
	
	
	public int[] getMinHeap(int[] arr){
		int[] minheap = new int[arr.length+1];
		for(int var:arr){
			insert(var,minheap);
		}
		return minheap;
	}
	
	public void insert(int n , int[] arr){
		int i = ++heapSize;
		while(i>1 && arr[i/2]>n){
			arr[i] = arr[i/2];
			i=i/2;
		}
		arr[i] = n;
	}
	
	public int remove(int[] heap){
		int smallest = 1;
		int temp = heap[smallest];
		heap[smallest] = heap[heapSize];
		sinkDown(heap,1);
		heapSize = heapSize -1;
		System.out.println("value poped:" + temp);
		return temp;
	}
	
	public void sinkDown(int[] heap,int i){
		int min =i;
		if(2*i < heapSize && heap[2*i] < heap[i]){
			min = 2*i;
		}
		if(2*i +1 < heapSize && heap[2*i+1] < heap[min]){
			min = 2*i +1;
		}
		if(min == i) return;
			int temp = heap[i];
			heap[i] = heap[min];
			heap[min] = temp;
			sinkDown(heap,min);
	}
	
	public static void main(String args[]){
		MinMaxHeap mmh = new MinMaxHeap();
		int[] input = {2,3,4,51,1,34,9};
		int[] res = mmh.getMinHeap(input);
		System.out.println(Arrays.toString(res));
		Thread thread = new Thread();
		thread.start();
		int loop = res.length;
		try {
			while(loop>1){
			Thread.sleep(2000);
			mmh.remove(res);
			loop--;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
