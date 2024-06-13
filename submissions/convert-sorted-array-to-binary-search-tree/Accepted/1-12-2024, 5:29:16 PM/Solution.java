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
        return helper(nums, 0, len-1);
        
    }
    
    private TreeNode helper(int[] nums, int st, int ed){
        if(st>ed) return null;
        
        int mid = st+(ed-st)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, st, mid-1);
        node.right = helper(nums, mid+1, ed);
        
        return node;
    }
}
