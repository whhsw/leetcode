/*
 *
 *Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten2(TreeNode root) {
        if(root == null)
            return;
        flatten(root.left);
        flatten(root.right);
        
        if(root.left == null)
            return;
        
        TreeNode left = root.left;
        while(left.right != null) {
            left = left.right;
        }
        left.right = root.right;
        root.right = root.left;
        root.left = null;
    }
    
    public void flatten(TreeNode root){
        if(root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode prev = null;
        while(!s.isEmpty()){
            TreeNode current = s.pop();
            if(current.right !=null)
                s.push(current.right);
            if(current.left != null)
                s.push(current.left);
            if(prev != null){
                prev.right = current;
                prev.left = null;
            }
            prev = current;
        }
    }
  
}
