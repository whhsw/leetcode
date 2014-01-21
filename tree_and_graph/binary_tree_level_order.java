/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 *
 * */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList rst = new ArrayList();
        if (root == null)
            return rst;
            
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
 
        while(!q.isEmpty()){
            ArrayList<Integer> line = new ArrayList<Integer>();
            int count = q.size();
            for(int i = 0; i < count; i++){
                TreeNode tmp = q.poll();
                line.add(tmp.val);
                
                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right !=null)
                    q.offer(tmp.right);
            }
            rst.add(line);

            //  rst.add(0, line);  if want bottom_up_solution =.=
        }
        return rst;
    }
}


// Zig-Zag
//
// return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
//
//
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if(root==null) return rst;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        boolean order = true;
        s.push(root);
        while(!s.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            Stack<TreeNode> next = new Stack<TreeNode>();
            
            for(!s.isEmpty()){
                TreeNode current = s.pop();
                tmp.add(current.val);
                if(order){
                    if(current.left != null) next.push(current.left);
                    if(current.right !=null) next.push(current.right);
                }else{
                    if(current.right != null) next.push(current.right);
                    if(current.left !=null) next.push(current.left);  
                }
            }
            
            order = !order;
            s = next;
            rst.add(tmp);
        }
        
        return rst;
    }
    
}



