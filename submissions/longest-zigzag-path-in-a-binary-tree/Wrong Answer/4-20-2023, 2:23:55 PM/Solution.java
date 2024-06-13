// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree

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
    
    public int longestZigZag(TreeNode root) {
        
        int left = helper(root, true, 0);
        int right = helper(root, false, 0);
        
         max = Math.max(max, left);
        max = Math.max(max, right);
        
        return max;
        
    }
    
    private int helper(TreeNode root, boolean prevRight, int curr){
        
        if(root==null)
            return curr;
        
        
        if(prevRight){
            if(root.left!=null){
                int res = helper(root.left, !prevRight, curr+1);
                max = Math.max(max, res);
            }
            
            int res = helper(root.right, prevRight, 0);
            max = Math.max(max, res);
            
        }else if(prevRight==false){
            
            if(root.right!=null){
                int res = helper(root.right, !prevRight, curr+1);
                max = Math.max(max, res);
            }
            
            int res = helper(root.left, prevRight, 0);
            max = Math.max(max, res);
        }
        
        return max;
    }
}