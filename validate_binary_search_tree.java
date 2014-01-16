/*
 * Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    int prev = Integer.MIN_VALUE;
    
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode current){
        if(current == null)
            return true;
  
        if(!inorder(current.left)){
            return false;
        }
        if(current.val <= prev) return false;
        
        prev = current.val;
        return inorder(current.right);
    }
    
}
