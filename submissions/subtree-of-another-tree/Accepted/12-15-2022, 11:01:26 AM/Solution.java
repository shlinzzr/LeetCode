// https://leetcode.com/problems/subtree-of-another-tree

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
     
        if(root==null && subRoot==null)
            return true;
        
        if(root==null || subRoot==null)
            return false;
        
        if(isSameTree(root, subRoot)){
            return true;
            
        }
        
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
        
        
    }
    
    private boolean isSameTree(TreeNode root, TreeNode sub){
        
        if(root==null && sub==null)
            return true;
        
        if(root==null || sub==null)
            return false;
        
        
        if(root.val== sub.val){
            
            boolean left= isSameTree(root.left, sub.left);
            boolean right= isSameTree(root.right, sub.right);
            
            return left && right;
        }else
            return false;
            
            
    }
    
}
