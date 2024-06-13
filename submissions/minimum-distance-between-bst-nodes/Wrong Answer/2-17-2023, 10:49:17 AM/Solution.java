// https://leetcode.com/problems/minimum-distance-between-bst-nodes

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
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        
        if(root==null)
            return 0;
        
        if(root.left!=null){
            min = Math.min(min, Math.abs(root.val-root.left.val));
            minDiffInBST(root.left);
        }
        
        if(root.right!=null){
            min = Math.min(min, Math.abs(root.val-root.right.val));
            minDiffInBST(root.right);
        }
        
        
        
        return min;
        
    }
}