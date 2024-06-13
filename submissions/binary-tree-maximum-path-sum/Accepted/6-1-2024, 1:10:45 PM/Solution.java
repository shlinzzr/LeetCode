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
    int max=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode node){
        if(node==null) return 0;

        int res = node.val;

        int left = getDepth(node.left);
        int right = getDepth(node.right);

        int big = Math.max(left, right);
        max = Math.max(max, left+right+res);

        max =Math.max(max, res);
        if(big<0) return res;

        max = Math.max(max, res+big);
        
        return res+big;

    }
}