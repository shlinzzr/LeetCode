// https://leetcode.com/problems/find-distance-in-a-binary-tree

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
    public int findDistance(TreeNode root, int p, int q) {
        

        // find lca
        // cal distance of [lca, p] + [lca, q]
        if(p==q) return 0;

        return helper(root, p, q);
    }


    private int helper(TreeNode node, int p, int q){
        if(node==null) return -1;

        if(node.val==p || node.val==q){
            return 1;
        }

        int left = helper(node.left, p, q);
        int right = helper(node.right, p, q);

        if(left>0 && right>0)
            return left + right;

     

        int res  = 1 + (left>0 ? left : right);

        // System.out.println(node.val + " " + left + " " + right + " " + res);

        return res;
    }
}