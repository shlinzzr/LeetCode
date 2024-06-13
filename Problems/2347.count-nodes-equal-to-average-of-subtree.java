// https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree

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
    
    int res=0;
    
    public int averageOfSubtree(TreeNode root) {
        
        runTree(root);
        return res;
    }
    
    private int[] runTree(TreeNode node){
        
        if(node==null){
            return new int[]{0,0};
        }
        
        int[] left = runTree(node.left);
        int[] right = runTree(node.right);
        
        int sum = left[0] + right[0] + node.val;
        int cnt = left[1] + right[1] + 1;
        
        if(sum/cnt==node.val){
            res ++;
        }
        
        return new int[]{sum , cnt};
        
    }
    
}