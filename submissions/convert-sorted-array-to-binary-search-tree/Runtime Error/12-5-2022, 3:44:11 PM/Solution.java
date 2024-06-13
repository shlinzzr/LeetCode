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
        
        
        TreeNode root = new TreeNode(nums[len/2]);
        if(len==1)
            return root;            
        
        // -10, -3, 0, 5, 9   len=5 %2==1
        //root = nums[2];
        // left = 0 ,2
        // right = 3, 4
        
        //[1,3] len=2 %2 =0
        // root = num[1];
        // left = 0, 1;
        // right = 
        
        
        
        
        int[] left = new int[len/2];
        System.arraycopy(nums, 0, left, 0, len/2);
        root.left = sortedArrayToBST(left);
        
        if(len/2+1 < len){
            int rIdx = len/2+1;
            int[] right = new int[len/2];
            System.arraycopy(nums, rIdx, right, 0, len/2);
            root.right = sortedArrayToBST(right);
        }
            
            
        
        
        
        
        
        
        return root;
    }
}