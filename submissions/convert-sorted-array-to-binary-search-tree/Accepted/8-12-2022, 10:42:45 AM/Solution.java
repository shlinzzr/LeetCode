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
        
        if(nums.length==0)
            return null;
        
        int mid = nums[nums.length/2];  //nums[5/2] = 0
        TreeNode root = new TreeNode(mid,
                                     sortedArrayToBST (Arrays.copyOfRange(nums, 0, nums.length/2) ),
                                     sortedArrayToBST( Arrays.copyOfRange(nums, nums.length/2+1, nums.length)));
        
        return root;
    
            
            
        
    }
}