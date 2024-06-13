// https://leetcode.com/problems/binary-tree-maximum-path-sum

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
    
    public int maxPathSum(TreeNode root) {
        getDepth(root);
        
        return max;
    }
    
    private int getDepth(TreeNode root){
        
        if(root==null)
            return 0;
        
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        
        max = Math.max(max, left+right+root.val);
        
        return Math.max(left, right) + root.val;
        
        
    }
    
}