/*
 *Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num) {
        return build(num, 0, num.length-1);
    }
    
    private TreeNode build(int[] num, int l, int r){
        if(l > r)
            return null;
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = build(num, l, mid-1);
        root.right = build(num, mid+1, r);
        return root;
    }
}
