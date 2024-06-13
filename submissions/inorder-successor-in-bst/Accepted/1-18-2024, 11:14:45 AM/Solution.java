// https://leetcode.com/problems/inorder-successor-in-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    TreeNode prev;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if(root==null) return null;
        
        TreeNode left = inorderSuccessor(root.left, p);
        if(left!=null) return left;
        
        if(prev==p)
            return root;
        
        
        prev = root;
        TreeNode right = inorderSuccessor(root.right, p);
        if(right!=null) return right;
        
        return null;
        
    }
}