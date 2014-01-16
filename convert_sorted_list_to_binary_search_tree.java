/*
 *Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //http://leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html 
 // need to think about this again
public class Solution {
    private class Result{
        ListNode head = null;
        TreeNode root = null;
        public Result(ListNode head, TreeNode root){
            this.head = head;
            this.root = root;
        }
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode tmp = head;
        while(tmp!=null){
            tmp = tmp.next;
            length++;
        }
        
        return build(head, 0, length-1).root;
    }
    
    public Result build(ListNode head, int start, int end){
        if(start > end)
            return new Result(head, null);
        
        int mid = (start + end) / 2;
        Result left = build(head, start, mid - 1);
        head = left.head;
        Result right = build(head.next, mid+1, end);
        
        TreeNode root = new TreeNode(head.val);
        root.left = left.root;
        root.right = right.root;
        return new Result(right.head, root);
    }
}
