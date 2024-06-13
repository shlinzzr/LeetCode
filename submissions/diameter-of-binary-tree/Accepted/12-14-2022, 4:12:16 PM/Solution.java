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
        // max = Math.max(max, getH(root.left)+getH(root.right));
        
//         diameterOfBinaryTree(root.left);
//         diameterOfBinaryTree(root.right);
        
        getH(root);
        
        
        return max;
    }
    
    
    private int getH(TreeNode root){
        
        if(root==null)
            return 0;
        
        int left = getH(root.left);
        int right = getH(root.right);
        
        max = Math.max(max, left+right);
        
        
        return Math.max(left, right)+1 ;
    }
}