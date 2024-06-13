// https://leetcode.com/problems/count-nodes-equal-to-sum-of-descendants

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
    int res = 0;

    public int equalToDescendants(TreeNode root) {
        getDesc(root);
        return res;
    }

    private int getDesc(TreeNode root){

        if(root==null) return 0;

        int left = getDesc(root.left);
        int right = getDesc(root.right);

        if(root.val==left+right) res++;

        // System.out.println(root.val + " " + left+ " " + right);

        return  root.val + left + right;

    }
}