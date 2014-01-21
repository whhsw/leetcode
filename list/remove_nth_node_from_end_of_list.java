Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pf = head;
        int count = 0;
        while(pf != null && count < n){
            pf = pf.next;
            count++;
        }
        if(pf == null){  // this is for the last node
            return head.next;
        }
        
        ListNode ps = head;
        while(pf.next != null){
            ps = ps.next;
            pf = pf.next;
        }
        ps.next = ps.next.next;
        return head;
    }
}
