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

    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;

        getMaxDepthSum(root);
        return max;
        
    }

    private int getMaxDepthSum(TreeNode root){
        if(root==null) return 0;

        if(root.left==null && root.right==null){
            max = Math.max(root.val, max);
            return root.val;
        }

        int left = getMaxDepthSum(root.left);
        if(left<0) left=0;

        int right = getMaxDepthSum(root.right);
        if(right<0)right=0;
        
        max = Math.max(max, left+right+root.val);

        return Math.max(left, right);
        

    }
}