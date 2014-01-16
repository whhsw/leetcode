// Construct Binary Tree from Inorder and Postorder Traversal 
//
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
			return null;
		
        return rebuild(inorder, 0, postorder, 0, postorder.length); 
    }
    
    public TreeNode rebuild(int[] inorder, int start1, int[] postorder, int start2, int length){
		if(length == 0)
		    return null;
		
		int val = postorder[start2 + length - 1];
		TreeNode root = new TreeNode(val);
		
		int i = 0;
		while(val != inorder[start1 + i]){
			i++;
		}
		
		root.left = rebuild(inorder, start1, postorder, start2, i);
		root.right = rebuild(inorder, start1 + i + 1, postorder, start2 + i, length - i - 1);
		
		return root;
    }
}

//Construct Binary Tree from Preorder and Inorder Traversal 
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        
        return build(preorder, 0, inorder, 0, inorder.length);
    }
    
    private TreeNode build(int[] preorder, int start1, int[] inorder, int start2, int length){
        if(length <= 0)
            return null;
        
        int value = preorder[start1];
        TreeNode root = new TreeNode(value);
            
        int i = 0;
        while(value != inorder[start2+i]){
            i++;
        }
        
        root.left = build(preorder, start1 + 1, inorder, start2, i);
        root.right = build(preorder, start1 + i + 1, inorder, start2 + i + 1, length - i -1);
        
        return root;
    }
}
