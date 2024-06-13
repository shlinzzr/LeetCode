// https://leetcode.com/problems/flatten-binary-tree-to-linked-list

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
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    // https://www.youtube.com/watch?v=rKnD7rLT0lI
    
    private TreeNode dfs(TreeNode curr){
        
        if(curr==null)
            return null;
        
        TreeNode leftTail = dfs(curr.left);
        TreeNode rightTail = dfs(curr.right);
        
        
        if(leftTail!=null){
            leftTail.right = curr.right;
            curr.right = curr.left;
            curr.left = null;    
        }
        
        
        if(rightTail!=null)
            return rightTail;
        else if(leftTail!=null)
            return leftTail;
        else 
            return curr;
        
        
        
    }
}