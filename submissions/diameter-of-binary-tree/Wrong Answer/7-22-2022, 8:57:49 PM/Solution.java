// https://leetcode.com/problems/diameter-of-binary-tree

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
    public int diameterOfBinaryTree(TreeNode root) {
        int dia = findDepth(root.left, 0) + findDepth(root.right, 0);
        
        return dia;
    }
    
    private int findDepth(TreeNode root, int d){
        
        if(root==null)
            return d;
        
        return Math.max(findDepth(root.left, d++), findDepth(root.right, d++));
        
    }
}