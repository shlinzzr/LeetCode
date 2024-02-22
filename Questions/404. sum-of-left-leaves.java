// https://leetcode.com/problems/sum-of-left-leaves

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
    
    int cnt=0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root==null)
            return 0;
        
        if(root.left!=null){
            
            if(root.left.left==null && root.left.right==null)
                cnt+=root.left.val;
            
            sumOfLeftLeaves(root.left);
        }
        
        sumOfLeftLeaves(root.right);
        
        return cnt;
        
        
        
    }
}