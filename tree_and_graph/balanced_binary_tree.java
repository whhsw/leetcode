/*
 *Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * */


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalanced2(root).balanced;
    }
    
	public Result isBalanced2(TreeNode node){
		if (node == null)
			return new Result(true, 0);
			
		Result r1 = isBalanced2(node.left);
		Result r2 = isBalanced2(node.right);
		
		boolean balanced = r1.balanced && r2.balanced && Math.abs(r1.depth - r2.depth) <= 1;
		int depth = Math.max(r1.depth, r2.depth) + 1;
		
		return new Result(balanced, depth);
		
	}
	
	private class Result{
		boolean balanced;
		int depth;
		
		public Result(boolean balanced, int depth){
			this.balanced = balanced;
			this.depth = depth;
		}
	}
    
}
