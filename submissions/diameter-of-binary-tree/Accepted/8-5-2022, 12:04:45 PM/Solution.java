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
    
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max;
    }
    
    private int getDepth(TreeNode root){
        
        if(root==null)
            return 0;
        
        int dl = getDepth(root.left);
        int dr = getDepth(root.right);
        
        max = Math.max(max, dl+dr);
        
        return Math.max(dl, dr)+1;
        
    }
    
}
