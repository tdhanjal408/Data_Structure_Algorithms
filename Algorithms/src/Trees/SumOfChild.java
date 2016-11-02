package Trees;

//Given a binary tree, change the value of the node by the sum of the values of its children.

public class SumOfChild {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int val){
			this.val = val;
		}
	}
	
	public  void getChildSum(TreeNode root){
		if(root == null) return ;
		helper(root);
	}
	
	// Helper method to call recursively
	public  int helper(TreeNode root){
		if(root == null) return 0;
		if(root.left == null && root.right ==null)  return root.val;
		root.val =helper(root.left) + helper(root.right); 
		return root.val;
	}
}
