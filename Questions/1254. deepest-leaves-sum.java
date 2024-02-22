// https://leetcode.com/problems/deepest-leaves-sum

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
    
    
    
    public int deepestLeavesSum(TreeNode root) {
        
        Map<Integer, Integer> lvSum = new LinkedHashMap<>();    
        helper(root, 0, lvSum);
        
        
        int max= 0;
        for(int k : lvSum.keySet()){
            // System.out.println("map(" + k + ")=" + lvSum.get(k) );
            
            max = Math.max(k, max);
        }
        
        return lvSum.get(max);
        
        
        
        
    }
    
    private void helper(TreeNode node, int level, Map<Integer, Integer> lvSum ){
    
        if(node==null)
            return;
    
        // System.out.println("nade.val=" + node.val + ")=" + lvSum.get(k) );
        lvSum.put(level, lvSum.getOrDefault(level, 0) + node.val);
        
        helper(node.left, level+1, lvSum);
        helper(node.right, level+1, lvSum);
        
        
    }
    
}