// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence

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
    
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        if(root==null)
            return 0;
        
        helper(root, 1);
        return max; 
    }
    
    private void helper(TreeNode root, int cur){
        if(root==null)
            return;
        
        max = Math.max(max, cur);
        
        if(root.left!=null){
            
            if(root.left.val==root.val+1){
                helper(root.left, cur+1);
            }else{
                helper(root.left, 1);
            }
        }
        if(root.right!=null){
            
            if(root.right.val==root.val+1){
                helper(root.right, cur+1);
            }else{
                helper(root.right, 1);
            }
        }
        
        
    }
    
}