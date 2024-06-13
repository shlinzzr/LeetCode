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

        TreeNode root = helper(nums, 0, len-1);
        return root;

    }

    private TreeNode helper(int[] nums, int low, int high){
        
        if(low>high)
            return null;

        int st=low, ed=high;
        int mid = st+(ed-st)/2;
        TreeNode left = helper(nums, st, mid-1);
        TreeNode right = helper(nums, mid+1, ed);
        TreeNode root = new TreeNode(nums[mid], left, right);
        return root;
    }
}