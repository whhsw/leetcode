/*
 *
 *A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 *
 * */



/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// Another method: make a copy of A->A'->B->B'.....
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        
        HashMap<RandomListNode, RandomListNode> hs = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = head;
        while(p != null){
            RandomListNode tmp = new RandomListNode(p.label);
            hs.put(p, tmp);
            p = p.next;
        }
        
        p = head;
        while(p != null){
           RandomListNode tmp = hs.get(p);
           tmp.next = hs.get(p.next);
           tmp.random = hs.get(p.random);
           p = p.next;
        }
        
        return hs.get(head);
    }
}
