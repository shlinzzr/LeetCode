// https://leetcode.com/problems/binary-tree-pruning

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        
         if(containOne(root)==false)
            return null;
        helper(root);
        
        return root;
    }
    
    private void helper(TreeNode root){
        
        if(root==null)
            return;
        
        if(root.left!=null){
            if( containOne(root.left)==false) 
                root.left=null;
            else 
                helper(root.left);
        }
            
        if(root.right!=null){
            
            if( containOne(root.right)==false) 
                root.right=null;
            else 
                helper(root.right);
        }
        
    }
    
    private boolean containOne(TreeNode root){
        
        if(root==null)
            return false;
        
        if(root.val==1)
            return true;
        
        boolean res = false;
        res = res || containOne(root.left);
        res = res || containOne(root.right);
        return res;
        
    }
}