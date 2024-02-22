// https://leetcode.com/problems/maximum-binary-tree

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        
        int max = 0;
        int maxIdx = 0;
        for(int i=0; i<nums.length; i++){
            
            if(max < nums[i]){
                max = nums[i];
                maxIdx = i;
            }
            
        }
        
        TreeNode root = new TreeNode(max);
        if(maxIdx!=0) root.left =  constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIdx));
        if(maxIdx!=nums.length-1) root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIdx+1, nums.length));
        
        return root;
        
    }
    
    
}