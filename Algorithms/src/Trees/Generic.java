package Trees;

public class Generic {

	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	 }
	
	// To get the node with max value
   	public int getMaxNode(TreeNode root,int max){
		if(root == null) return Math.max(Integer.MIN_VALUE,max);
		if(max < root.val) max = root.val;
		return Math.max(getMaxNode(root.left,max), getMaxNode(root.right,max));
	}
   	
   	
}
