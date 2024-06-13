// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers

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
    int sum;
    public int sumRootToLeaf(TreeNode root) {
        sum=0;
        helper(root, 0);
        
        return sum;
    }
    
    private void helper(TreeNode root, int curr){
        if(root==null)
            return ;
        curr = curr <<1;
        curr += root.val;
        
        
        if(root.left==null && root.right==null){
            sum+=curr;
        }
        
        helper(root.left, curr);
        helper(root.right, curr);
    }
}