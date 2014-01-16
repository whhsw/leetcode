Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.


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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode p = head;
        while(p!= null && p.next != null){
            if(p.val == p.next.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        
        return head;
    }
    
    
    // This use extra space, not good
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        HashSet<Integer> occured = new HashSet<Integer>();
        ListNode p = head;
        occured.add(head.val);
        while(p != null & p.next!=null){
            if(occured.contains(p.next.val)){
                p.next = p.next.next;
            }else{
                occured.add(p.next.val);
                p = p.next;
            }
        }
        
        return head;
    }
}


Remove Duplicates from Sorted List II 
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode p = new ListNode(0);
        p.next = head;
        head = p;
        
        while(p.next != null && p.next.next != null){
            if(p.next.val == p.next.next.val){
                int tmp = p.next.val;
                ListNode larger = p.next.next;
                while(larger != null && larger.val == tmp){
                    larger = larger.next;
                }
                p.next = larger;
            }else{
                p = p.next;
            }
        }
        
        return head.next;
    }
}
