Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.


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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;
        while(p.next != null && p.next.next != null){
            ListNode tmp = p.next.next.next;
            p.next.next.next = p.next;
            p.next = p.next.next;
            p.next.next.next = tmp;
            p = p.next.next;
        }
        return head.next;
    }
}
