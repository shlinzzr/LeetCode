// https://leetcode.com/problems/maximum-average-subtree

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
    double max= 0 ;
    public double maximumAverageSubtree(TreeNode root) {
        
        if(root==null){
            return 0.0;
        }

        max = Math.max(max, getSumOfSubtree(root)/ getCntOfSubtree(root));
        double left = maximumAverageSubtree(root.left);
        double right = maximumAverageSubtree(root.right);

        return Math.max(max, Math.max(left, right));


    }

    private double getCntOfSubtree(TreeNode root){
        if(root==null)
            return 0;
        
        double left = getCntOfSubtree(root.left);
        double right = getCntOfSubtree(root.right);
        return 1.0+ left+right;

    }


    private double getSumOfSubtree(TreeNode root){
        if(root==null){
            return 0;
        }

        double left = getSumOfSubtree(root.left);
        double right = getSumOfSubtree(root.right);
        return Double.valueOf(root.val + left + right);
    }
}