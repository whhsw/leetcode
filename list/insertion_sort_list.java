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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        
        while(head != null){
            ListNode p = dummy;
            while(p.next != null && p.next.val <= head.val){
                p = p.next;
            }

            ListNode tmp = p.next;  // it's fine even if p.next is null;
            p.next = head;
            head = head.next;
            p = p.next;
            p.next = tmp;
            
        }
        return dummy.next;
    }
}
