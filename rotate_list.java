Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

Discuss


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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null)
            return head;
        
        // Get length
        int len = 0;
        ListNode p = head;
        ListNode last = head;
        while(p!= null){
            len++;
            last = p;
            p = p.next;
        }
        
        //find index
        n = len - n % len;
        if(n == len)
            return head;
        
        // break the list
        p = head;
        while(n - 1 > 0){
            p = p.next;
            n--;
        }
        
        last.next = head;
        head = p.next;
        p.next = null;
        return head;
        
        
    }
}
