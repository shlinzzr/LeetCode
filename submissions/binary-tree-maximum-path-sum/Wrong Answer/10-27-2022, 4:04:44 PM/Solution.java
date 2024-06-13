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
    
    // 先想看看遞迴有沒有辦法解
    
    
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        
        return max;
    }
    
    private int helper(TreeNode root){
        
        if(root==null)
            return 0;
        
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        
        int sum = root.val;
        if(left>0)
            sum+=left;
        if(right>0)
            sum+=right;
        
        max = Math.max(max,sum);
        
        return root.val + Math.max(left,right);
    }
    
}