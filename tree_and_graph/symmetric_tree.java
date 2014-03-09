/*
 *Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
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
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }
    
    private boolean isSym(TreeNode left, TreeNode right){
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val 
            && isSym(left.left, right.right) 
            && isSym(left.right, right.left);
    }
    
    
    public boolean isSymmetric(TreeNode root){
        if (root == null)
            return true;
        Queue<TreeNode> left = new LinkedList<TreeNode>();
        Queue<TreeNode> right = new LinkedList<TreeNode>();
        
        left.offer(root.left);
        right.offer(root.right);
        
        while(!left.isEmpty() && !right.isEmpty()){
            TreeNode n1 = left.poll();
            TreeNode n2 = right.poll();
            if( (n1 == null && n2 != null) || (n1 != null && n2 == null))
                return false;
            if (n1 !=null){
                if (n1.val != n2.val)
                    return false;
                left.offer(n1.left);
                left.offer(n1.right);
                right.offer(n2.right);
                right.offer(n2.left);
            }
        }
        return true;
    }
}
