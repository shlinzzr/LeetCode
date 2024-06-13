// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree

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
    int total = 0;
    public int maxProduct(TreeNode root) {
        total = getTotal(root);
        getHalf(root);

        return max;
    }

    private int getHalf(TreeNode root){
        if(root==null) return 0;
        
        int left = getHalf(root.left);
        int right = getHalf(root.right);

        int half = left + right + root.val;
            max = Math.max(max, half*(total-half));

        return half;
        
    }

    private int getTotal(TreeNode root){
        if(root==null) return 0;
        int left = getTotal(root.left);
        int right = getTotal(root.right);

        return left + right + root.val;
    }


}