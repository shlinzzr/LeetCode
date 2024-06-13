// https://leetcode.com/problems/closest-leaf-in-a-binary-tree

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

    int abs = Integer.MAX_VALUE;
    int res = -1;

    public int findClosestLeaf(TreeNode root, int k) {

        helper(root, k);

        return res;
        
    }

    private void helper(TreeNode node , int k){
        if(node==null) return ;

        // abs = Math.min(abs, Math.abs(node.val-k));

        if(node.left==null && node.right==null && abs> Math.abs(node.val-k)){
            abs = Math.abs(node.val-k);
            res = node.val;
        }
        helper(node.left, k);
        helper(node.right, k);
    }
}