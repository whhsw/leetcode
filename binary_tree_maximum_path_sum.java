/*
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    private class Result{
        int max_path;
        int max_sum;
        
        public Result(int max_path, int max_sum){
            this.max_path = max_path;
            this.max_sum = max_sum;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        return find(root).max_sum;
    }
    
    private Result find(TreeNode root){
        if (root == null)
            return new Result(0, Integer.MIN_VALUE);

        Result left = find(root.left);
        Result right = find(root.right);
        
        int max_path = findmax(root.val, left.max_path + root.val, right.max_path + root.val);
        int max_sum = findmax(max_path, left.max_sum, right.max_sum, left.max_path + right.max_path + root.val);
        
        return new Result(max_path, max_sum);
    }
    
    private int findmax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    
    private int findmax(int a, int b, int c, int d){
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
    
    // This is more neat but OJ doesn't support it
    private int findmax_neat(Integer... a){
        return Collections.max(Arrays.asList(a));
    }


}
