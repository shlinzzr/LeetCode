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
    long max = 0;
    long total = 0;
    int M = (int) 1e9+7;
    public int maxProduct(TreeNode root) {
        total = getTotal(root);
        getTotal(root);

        return (int) (max%M);
    }

    private long getTotal(TreeNode root){
        if(root==null) return 0;
        
        long left = getTotal(root.left);
        long right = getTotal(root.right);

        long sub =root.val + left + right ;
        max = Math.max(max, sub*(total-sub));

        return sub;
        
    }

    // private long getTotal(TreeNode root){
    //     if(root==null) return 0;
    //     long left = getTotal(root.left);
    //     long right = getTotal(root.right);
    //     long sum  = left + right  + root.val;
    //     max = Math.max(max, sum*(total-sum));

    //     return sum;
    // }


}