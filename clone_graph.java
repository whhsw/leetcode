/*
 *
 *Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:
 * */


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> created = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode first = new UndirectedGraphNode(node.label);
        first.neighbors.addAll(node.neighbors);
        q.offer(first);
        
        while(!q.isEmpty()){
            UndirectedGraphNode current = q.poll();
            for(int i = 0; i < current.neighbors.size(); i++){
                UndirectedGraphNode tmp = current.neighbors.get(i);

                if (tmp.label == current.label){   // this is for self-loop
                    current.neighbors.set(i, current);
                }else if (created.containsKey(tmp)) {   // this is for already created
                    current.neighbors.set(i, created.get(tmp));
                } else{
                    UndirectedGraphNode next = new UndirectedGraphNode(tmp.label);
                    next.neighbors.addAll(tmp.neighbors);
                    created.put(tmp, next);
                    current.neighbors.set(i, next);
                    q.offer(created.get(tmp));                    
                }
            }
        }
        
        return first;
    }
}
