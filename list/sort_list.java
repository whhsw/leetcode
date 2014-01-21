/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
 *
 *Sort a linked list in O(n log n) time using constant space complexity.
 * */
public class Solution {
    // Another backtracking question!!
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode head = p;
        while(l1 != null && l2 != null){
            if ( l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return head.next;
    }
    
    
    private class Result{
        ListNode head = null;
        ListNode list = null;
        
        public Result(ListNode head, ListNode list){
            this.head = head;
            this.list = list;
        }
    }
    
    public ListNode sortList(ListNode head) {
        if(head == null) 
            return head;
        int len = 0;
        ListNode tmp = head;
        while(tmp!= null){
            len++;
            tmp = tmp.next;
        }
        
        return mergesort(head, 0, len-1).list;
    }
    
    private Result mergesort(ListNode head, int start, int end){
        if(start > end)
            return new Result(head, null);
        else if(start == end){
            ListNode current = head;
            head = head.next;
            current.next = null;
            return new Result(head, current);
        }
        
        int mid = (start+end)/2;
        Result left = mergesort(head, start, mid);
        Result right = mergesort(left.head, mid+1, end);
        return new Result(right.head, merge(left.list, right.list));
    }
}
