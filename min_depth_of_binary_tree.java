/*
 *Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return get_min(root);
    }
    
    public int get_min(TreeNode root){
        if(root == null)
            return Integer.MAX_VALUE;
        if(root.left == null && root.right == null)
            return 1;
        
        return Math.min(get_min(root.left), get_min(root.right)) + 1;
    }
    
    
    /* This method will be faster
    public int minDepth(TreeNode node) {
    	if(node == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();  
		q.offer(node);
		int depth = 0;
		while(!q.isEmpty()){
		    depth ++;
			int count = q.size();
			while(count > 0){  
				TreeNode tmp = q.poll();
				count --;
				if(tmp.left == null && tmp.right ==null)
				    return depth;
				if(tmp.left != null)
					q.offer(tmp.left);
				if(tmp.right != null)
					q.offer(tmp.right);	
				
			}
		}
		return depth;
    }
    */
}
