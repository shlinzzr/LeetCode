// https://leetcode.com/problems/count-good-nodes-in-binary-tree

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
    int res =0;
    public int goodNodes(TreeNode root) {
        
        helper(root, root.val);
        return res;
    }
    
    private void helper(TreeNode root, int currMax){
        
        if(root==null)
            return;
        
        if(root.val>=currMax){
            res++;
            currMax = root.val;
        }
            
        
        helper(root.left, currMax);
        helper(root.right, currMax);
        
        
    }
}