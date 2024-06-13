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
    public int countNodes(TreeNode root) {
        
        if(root==null)
            return 0;
        
        return helper(root, 1);
        
    }
    
    private int helper(TreeNode root, int idx){
    
        int right = (root.right!=null) ? helper(root.right, 2*idx+1) : -1;
        int left = (root.left!=null) ? helper(root.left, 2*idx) : -1;

        int max = Math.max(left, right);
        return Math.max(max, idx);
    }
    
    
    
    
    
}
