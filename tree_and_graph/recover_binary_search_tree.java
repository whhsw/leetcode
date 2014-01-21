/*
 *Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    TreeNode[] list = new TreeNode[2];
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int tmp = list[0].val;
        list[0].val = list[1].val;
        list[1].val = tmp;
    }
    
    private void inorder(TreeNode current){
        if(current == null)
            return;
        inorder(current.left);
        
        if(current.val <= prev.val){
            if(list[0] == null){
                list[0] = prev;
                list[1] = current;
            }else{
                list[1] = current;
            }
        }
        prev = current;
        inorder(current.right);
    }
}
