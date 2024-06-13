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
    int max=0;
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return max;
    }

    private int getSum(TreeNode node){
        if(node==null)
            return 0;

        int left =  Math.max(0 ,getSum(node.left) );
        int right = Math.max(0 ,getSum(node.right) );

        max = Math.max(max, left + right + node.val);

        return node.val + Math.max(left, right);
    }

}