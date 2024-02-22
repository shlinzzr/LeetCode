// https://leetcode.com/problems/two-sum-bsts

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
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> set = new HashSet();
        helper(root1, set);
        
        return helper2(root2, set, target);
        
    }
    
    private boolean helper2(TreeNode r2, HashSet<Integer> set, int target){
        
        if(r2==null)
            return false;
        
        int find = target-r2.val;
        
        if(set.contains(find))
            return true;
        
        
        
        
        return helper2(r2.left,set,target) || helper2(r2.right, set, target);
        
        
        
    }
    
    
    private void helper(TreeNode r1, HashSet<Integer> set){
        if(r1==null)
            return;
        
        
        set.add(r1.val);
        
        helper(r1.left, set);
        helper(r1.right,set);
    }
        
}


