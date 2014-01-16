Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


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
 
 // remember priority queue && comparator
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
            
        PriorityQueue<ListNode> min_heap = new PriorityQueue<ListNode>(lists.size(), new NodeComparator());  
        //no need to declare when initialzing ; cuz comparator has restricted it already
        for(ListNode list : lists){
            if(list!=null)
                min_heap.add(list);
        }
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(min_heap.size() != 0){
            p.next = min_heap.poll();
            p = p.next;
            if(p.next != null)
                min_heap.add(p.next);
        }
        return head.next;
        
    }
    
    private class NodeComparator implements Comparator<ListNode> {   // only need to declare T in comparator
        public int compare(ListNode a, ListNode b){   //need to be public here
            return a.val - b.val;
        }
    }
}
