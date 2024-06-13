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
    
    int max=0;
    
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null)
            return 0;
        
        max = Math.max(max, getH(root.left, 0)+getH(root.right, 0));
        return max;
    }
    
    
    private int getH(TreeNode root, int h){
        
        if(root==null)
            return h;
        
        int left = getH(root.left, h+1);
        int right = getH(root.right, h+1);
        
        return Math.max(left, right);
    }
}