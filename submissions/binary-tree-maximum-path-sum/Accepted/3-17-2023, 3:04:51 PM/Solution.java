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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        getDepth(root);
        return max;
        
    }
    
    
    private int getDepth(TreeNode root){ // 1. 先定義這個func. 一定是回傳leafSum
        if(root==null)
            return 0;
        
        
        int left = Math.max(0, getDepth(root.left));
        int right = Math.max(0, getDepth(root.right));
        
        max = Math.max(max, left+right+root.val); // 這個時候 全域變數的max 就會跟left+right+val比
        
        return Math.max(left, right)+root.val; //1.a 這裡回傳max(left, right) + root.val
        
        
    }
}