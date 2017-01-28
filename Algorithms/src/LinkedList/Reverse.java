package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Reverse {

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}
	}

	// Reverse a Linked List from m to n
	public ListNode reverseBetween(ListNode a, int m, int n) {
		if (a == null || a.next == null || n <= m)
			return a;
		int count = 0;
		ListNode fakeNode = new ListNode(-1);
		ListNode out = fakeNode;
		ListNode head = null;
		fakeNode.next = a;

		while (count < m) {
			count++;
			head = fakeNode;
			fakeNode = fakeNode.next;
		}

		ListNode next = null;
		ListNode prev = null;
		ListNode curr = fakeNode;
		ListNode tail = null;

		while (count <= n && curr != null) {
			next = curr.next;
			curr.next = prev;
			if (prev == null)
				tail = curr;
			prev = curr;
			curr = next;
			count++;
		}

		head.next = prev;
		tail.next = curr;
		return out.next;

	}
	
	// check if linked list is palindrome 
	public int lPalin(ListNode A) {
		if (A == null)
			return 0;
		if (A.next == null)
			return 1;

		ListNode slow = A;
		ListNode fast = A;
		Stack<ListNode> stack = new Stack<Reverse.ListNode>();

		while (slow != null && fast != null && fast.next != null) {
			stack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null)
			slow = slow.next;

		while (!stack.isEmpty()) {
			if (stack.pop().val != slow.val)
				return 0;
			slow = slow.next;
		}
		return 1;
	}

	//Given {1,2,3,4}, reorder it to {1,4,2,3}.
	public ListNode reorderList(ListNode a) {
		if(a==null || a.next ==null|| a.next.next ==null) return a;
		
		ListNode slow = a;
		ListNode fast = a;
		Stack<ListNode> stack = new Stack<Reverse.ListNode>();

		while (slow != null && fast != null && fast.next != null) {
			stack.push(slow);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if (fast != null){
			ListNode prev = slow;
			slow = slow.next;
			prev.next=null;
		}	
		else{
			ListNode prev = slow;
			slow = slow.next;
			stack.pop();
			prev.next=null;
		}
		
		while(!stack.isEmpty()){
			ListNode sNode = stack.pop();
			ListNode next = sNode.next;
			sNode.next= slow;
			slow=slow.next;
			sNode.next.next=next;
		}
		
		return a;
	}
	
	
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length ==0) return null;
        ListNode fakeNode= new ListNode(-1);
        ListNode curr = fakeNode;
        List<ListNode> heap = new ArrayList<ListNode>();
        heap.set(0, null);
        for(ListNode node : lists){
        	insert(node,heap);
        }
        
        while(heap.size()>1){
        	ListNode minNode = remove(heap);
        	curr.next= minNode;
        	ListNode nextNode = minNode.next;
        	minNode.next = null;
        	if(nextNode!=null) insert(nextNode,heap);
        	curr= curr.next;
        }
        
        return fakeNode.next;
    }
    
    
    public void insert(ListNode node ,List<ListNode> heap){
    	heap.add(heap.size()+1,node);
    	int i = heap.size();
    	while(i>1 && heap.get(i/2).val > heap.get(i).val){
			ListNode tempNode = heap.get(i);
			heap.set(i,heap.get(i/2));
			heap.set(i/2,tempNode);
			i=i/2;
		}
	}
	
	public ListNode remove(List<ListNode> heap){
		int smallest = 1;
		ListNode node = heap.get(1);
		ListNode lastNode = heap.get(heap.size()-1);
		heap.remove(heap.size()-1);
		heap.set(1,lastNode);
		sinkDown(heap,1);
		return node;
	}
	
	public void sinkDown(List<ListNode> heap,int i){
		int min =i;
		if(2*i < heap.size() && heap.get(2*i).val < heap.get(i).val){
			min = 2*i;
		}
		if(2*i +1 < heap.size()  && heap.get(2*i +1).val < heap.get(min).val){
			min = 2*i +1;
		}
		if(min == i) return;
			ListNode tempNode = heap.get(i);
			heap.set(i,heap.get(min));
			heap.set(min,tempNode);
			sinkDown(heap,min);
	}
	
	
    

	public static void main(String[] args) {
		Reverse r = new Reverse();
		ListNode node1 = r.new ListNode(1);
		ListNode node2 = r.new ListNode(2);
		node1.next = node2;
		ListNode node3 = r.new ListNode(3);
		node2.next = node3;
		ListNode node4 = r.new ListNode(4);
		node3.next = node4;
		ListNode node5 = r.new ListNode(5);
		node4.next = node5;
		ListNode node6 = r.new ListNode(6);
		node5.next = node6;

		// ListNode res = r.reverseBetween(node1, 2, 4);
		// System.out.println(r.lPalin(node1));
		ListNode res = r.reorderList(node1);
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}

	}

}
