// https://leetcode.com/problems/minimum-absolute-difference-in-bst

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
    
    TreeSet<Integer> set = new TreeSet<>();
    
    public int getMinimumDifference(TreeNode root) {
        
        if(root==null)
            return 0;
        
        set.add(root.val);
        
        if(root.left!=null)
            getMinimumDifference(root.left);
        
        if(root.right!=null)
            getMinimumDifference(root.right);
        
        int min = Integer.MAX_VALUE;
        
        Integer prev =null;
        for(int t : set){
            if(prev==null){
                prev=t;
                continue;
            }
                
            min = Math.min(min, t-prev);
            prev = t;
        }
        
        
        return min;
    }
}