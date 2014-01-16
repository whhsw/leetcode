Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.



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
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;
        
        ListNode small = new ListNode(0); // create a dummy node to make it easier for coding
        ListNode large = new ListNode(0); // This trick makes it much easier !!!
        
        ListNode head1 = small;
        ListNode head2 = large;
        
        ListNode p = head;
        while(p != null){
            if(p.val < x) {
                small.next = p;
                small = small.next;
            }else{
                large.next = p;
                large = large.next;
            }
            p = p.next;
        }
        
        large.next = null; // don't forget this!
        small.next = head2.next;
        return head1.next;
    }
}
