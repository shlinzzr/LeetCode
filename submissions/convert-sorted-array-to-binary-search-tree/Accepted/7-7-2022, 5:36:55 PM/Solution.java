// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree

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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        
        return helper(nums, 0, nums.length-1);
        
    }
    
    private TreeNode helper(int[] nums, int st, int ed){
        
        if(st>ed)
            return null;
        
        // if(st==ed)
        //     return new TreeNode(nums[st], null, null);

        int mid = (st+ed)/2;
        TreeNode root = new TreeNode(nums[mid], helper(nums, st, mid-1), helper(nums, mid+1,ed));
        
        return root;
        
    }
}