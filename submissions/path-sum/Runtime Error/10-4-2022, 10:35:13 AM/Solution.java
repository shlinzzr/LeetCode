// https://leetcode.com/problems/path-sum

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum, 0);
    }
    
    private boolean helper(TreeNode root, int targetSum, int currSum){
        
        if(root.left==null && root.right==null)
            if(currSum+root.val==targetSum)
                return true;
            else 
                return false;
        
        currSum+=root.val;
        
        boolean res = false;
        if(root.left!=null)
            res = res || helper(root.left, targetSum, currSum);
        
        if(root.right!=null)
            res = res || helper(root.right, targetSum, currSum);
            
        
        return res;
        
        
    }
}