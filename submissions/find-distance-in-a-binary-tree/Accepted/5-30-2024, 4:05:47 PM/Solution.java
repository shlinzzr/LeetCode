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
        TreeNode lca = find(root, p, q);

        int left = getDepth(lca, p, 0);
        int right = getDepth(lca, q, 0);


        // System.out.println(left + " " + right+ " " +lca.val);

        return left+right;
    }

    private int getDepth(TreeNode node, int p, int lv){
        if(node==null) return Integer.MAX_VALUE/2;

        if(node.val==p) return lv;

        int left = getDepth(node.left, p, lv+1);
        int right = getDepth(node.right, p, lv+1);

        return Math.min(left, right);

        



    }

    private TreeNode find(TreeNode node , int p, int q){
        if(node==null) return null;
        if(node.val==p || node.val==q)
            return node;

        TreeNode left = find(node.left, p, q);
        TreeNode right = find(node.right, p, q);
        if(left!=null&& right!=null)return node;

        return left==null ? right : left;
    }
}