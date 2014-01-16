Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.


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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m==n )
            return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        ListNode prev = head;
        int count = 0;
        while(count < m-1){
            count++;
            prev = prev.next;
        }
        
        
        ListNode n1 = prev.next;
        while(n1.next!= null && count < n-1){   // interesting trick
            count++;
            ListNode tmp = n1.next;
            n1.next = tmp.next;
            tmp.next = prev.next;
            prev.next = tmp;
        }
        
        return head.next;
 
    }
}
