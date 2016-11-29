package LinkedList;

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

	public static void main(String[] args) {
		Reverse r = new Reverse();
		ListNode node1 = r.new ListNode(1);
		ListNode node2 = r.new ListNode(2);
		node1.next = node2;
		ListNode node3 = r.new ListNode(3);
		node2.next = node3;
		ListNode node4 = r.new ListNode(3);
		node3.next = node4;
		ListNode node5 = r.new ListNode(1);
		node4.next = node5;

		// ListNode res = r.reverseBetween(node1, 2, 4);
		System.out.println(r.lPalin(node1));
		ListNode res = node1;
		while (res != null) {
			System.out.print(res.val + "->");
			res = res.next;
		}

	}

}
