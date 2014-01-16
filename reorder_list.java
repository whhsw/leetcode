/*
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.

*/
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
public class Solution {
    // should remeber this 
    public void reorderList(ListNode head) {
        if(head == null)
            return;
            
        // Find median point
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Reverse second half
        ListNode first = slow;
        ListNode second = slow.next;
        first.next = null;
        while(second != null){
            ListNode tmp = second;
            second = second.next;
            tmp.next = first;
            first = tmp;
        }
        
        // Merge two list
        ListNode start = head;
        ListNode end = first;
        while(start!= null && end!=null && start != end){
            ListNode tmp = end.next;
            end.next = start.next;
            start.next = end;
            start = end.next;
            end = tmp;
        }
        
    }
}


