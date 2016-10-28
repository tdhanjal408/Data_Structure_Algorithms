package Trees;

import java.util.Stack;

public class InOrder {

	private class Tree{
		int val;
		Tree left;
		Tree right;
	}
	public void inOrder(Tree root){
		Stack<Tree> stack = new Stack<Tree>();
		while(true){
			while(root!=null){
				stack.push(root);
				root = root.left;
			}
			if(stack.isEmpty()) return;
			Tree node = stack.pop();
			System.out.println(node.val);
			if(node.right!=null) root = root.right;
		}
	}
	

}
