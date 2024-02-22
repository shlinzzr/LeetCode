// https://leetcode.com/problems/path-sum-iii

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
    
    int res= 0; 
    
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        
        helper(root, targetSum, 0L, map);
        
        
        return res;
    }
    
    
    private void helper(TreeNode root, int target, long curr, HashMap<Long, Integer> map ){
        
        if(root==null)
            return;
        
        curr+=root.val;
        if(map.containsKey(curr-target)){
            res += map.get(curr-target);
        }
        map.put(curr, map.getOrDefault(curr,0)+1);
        helper(root.left, target, curr, map);
        helper(root.right, target, curr, map);
        map.put(curr, map.get(curr)-1);
        
        
    }
}