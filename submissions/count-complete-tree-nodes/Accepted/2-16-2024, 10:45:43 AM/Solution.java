// https://leetcode.com/problems/count-complete-tree-nodes

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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        helper(root, 0);
        return max+1;
    }

    private void helper(TreeNode root, int idx){
        if(root==null) return;

        max = Math.max(max, idx);
        helper(root.left, 2*idx+1);
        helper(root.right, 2*idx+2);

    }

    
}