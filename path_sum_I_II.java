/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * */

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return sum == root.val;
        return hasPathSum (root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}

/*
 *Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 *
 * */


 // DFS, using stack
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();

        find_sum(rst, solution, root, sum);
        return rst;
    }
    
    private void find_sum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, TreeNode root, int sum){
        if(root == null)
            return;
        
        sum -= root.val;
        if(root.left == null && root.right == null){
            if(sum == 0){
                solution.add(root.val);
                result.add(new ArrayList<Integer>(solution));
                solution.remove(solution.size()-1);
            }
            return;
        }  
        
        solution.add(root.val);
        find_sum(result, solution, root.left, sum);
        find_sum(result, solution, root.right, sum);
        solution.remove(solution.size()-1);
    }
    
    
    
    
    public ArrayList<ArrayList<Integer>> pathSum_iterative(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return rst;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Integer> acc_sums = new Stack<Integer>();
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        
        s.push(root);
        acc_sums.push(root.val);
        
        while(!s.isEmpty()){
            TreeNode current = s.pop();
            int acc_sum = acc_sums.pop();
            path.add(current);
            
            if(current.left == null && current.right == null){
                if(acc_sum == sum){
                    rst.add(getpath(path));
                }
                path.remove(path.size()-1); // remove the one that is just added;
                while(!s.isEmpty() && !path.isEmpty() && path.get(path.size()-1).right != s.peek()){
                    path.remove(path.size()-1);
                }
            }
            
            if(current.right != null){
                s.push(current.right);
                acc_sums.push(acc_sum + current.right.val);
            }
            if(current.left != null){
                s.push(current.left);
                acc_sums.push(acc_sum + current.left.val);
            }
        }
        
        return rst;
    }
    
    private ArrayList<Integer> getpath(ArrayList<TreeNode> list){
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for(TreeNode n: list){
            tmp.add(n.val);
        }
        return tmp;
    }
}
