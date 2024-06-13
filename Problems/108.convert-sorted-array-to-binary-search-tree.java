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

        return helper(nums , 0, len-1);
        
    }

    // -10, -3, 0, 5, 9 => len= 5, mid =2
    // node =0
    

    private TreeNode helper(int[] nums, int left, int right){

        if(left>right) return null;

        int mid = (left+right)/2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid-1);
        node.right = helper(nums, mid+1, right);

        return node;
    }
}