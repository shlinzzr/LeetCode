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
        int len = nums.length;
        
        if(len==0)
            return null;
        
        if(len==1)
            return new TreeNode(nums[0]);
        
        int mid = nums[len/2];
        TreeNode root = new TreeNode(mid);
       
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, len/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, len/2+1, len));
        
        return root;
        
    }
}