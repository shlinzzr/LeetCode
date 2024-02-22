// https://leetcode.com/problems/house-robber-iii

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
    public int rob(TreeNode root) {
        if(root==null) return 0;
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return helper(root, map);
    }
    
    private int helper(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root==null) return 0;
        
        if(map.containsKey(root))
            return map.get(root);
        
        int max = Math.max( doRob(root, map), doNotRob(root, map));
        
        map.put(root, max);
        
        return max ;
    }
    
    private int doRob(TreeNode root,  HashMap<TreeNode, Integer> map){
        if(root==null) return 0;
        return doNotRob(root.left, map) + root.val + doNotRob(root.right, map);
    }
    
    private int doNotRob(TreeNode root,  HashMap<TreeNode, Integer> map){
        if(root==null) return 0;
        return helper(root.left, map) + helper(root.right, map);   
    }
    
    
}