/*
 * Given a linked list, determine if it has a cycle in it.
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
    public boolean hasCycle(ListNode head) {
        ListNode pf = head;
        ListNode ps = head;
        while(ps != null && pf != null && pf.next != null){
            ps = ps.next;
            pf = pf.next.next;
            if(ps == pf)
                return true;
        }
        return false;
    }
}

/*
 *Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * */

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode pf = head;
        ListNode ps = head;
        while(ps != null && pf != null && pf.next != null){
            ps = ps.next;
            pf = pf.next.next;
            if(ps == pf)
                break;
        }
        
        if(ps == null || pf == null || pf.next == null)
            return null;
        
        ps = head;
        while(ps != pf){
            ps = ps.next;
            pf = pf.next;
        }
        
        return ps;
    }
}
