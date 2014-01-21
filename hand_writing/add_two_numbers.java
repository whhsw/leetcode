You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
            
        ListNode head = new ListNode(0);
        ListNode p = head;
        int carry = 0;
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        
        
        while(l1 != null) {
            int sum =  carry + l1.val;
            p.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            p = p.next;
        }
        
        while(l2 != null) {
            int sum =  carry + l2.val;
            p.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            p = p.next;
        }
        
        if (carry != 0)
            p.next = new ListNode(carry);
        
        return head.next;
    }
}
