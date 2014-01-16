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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        if (root == null){
            return rst;
        }
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()){
            TreeNode current = s.pop();
            if(current.right != null){
                s.push(current.right);
            }
            if (current.left != null){
                s.push(current.left);
            }
            rst.add(current.val);
        }
        return rst;
    }



    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        TreeNode current = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(true){
            while(current != null){
                s.push(current);
                current = current.left;
            }
            if (s.isEmpty())
                return rst;
            current = s.pop();
            rst.add(current.val);
            current = current.right;
        }
        
    }


    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        while(true){
            while(current != null){
                if(current.right != null){
                    s.push(current.right);
                }
                s.push(current);
                current = current.left;
            }
            if(s.isEmpty()){
                return rst;
            }
            
            current = s.pop();
            if(current.right != null && !s.isEmpty() && current.right == s.peek()){
                s.pop();
                s.push(current);
                current = current.right;
            }else{
                rst.add(current.val);
                current = null;
            }
        }
    
    }
    
}


