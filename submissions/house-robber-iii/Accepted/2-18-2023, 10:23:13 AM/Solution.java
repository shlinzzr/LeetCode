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
        if(root == null) return 0;
        
        Map<TreeNode, Integer> hmap = new HashMap<>();
        
        return robImpl(root, hmap);
    }
    
    private int robImpl(TreeNode node, Map<TreeNode, Integer> hmap) {
        if(node == null) return 0;
        
        if(hmap.containsKey(node)) return hmap.get(node);
        
        int count = Math.max(robIncluded(node, hmap), robExcluded(node, hmap));
        
        hmap.put(node, count);
        return count;
    }
    
    int robExcluded(TreeNode node, Map hmap) {
        if(node == null) return 0;
        return robImpl(node.left, hmap) + robImpl(node.right, hmap);
    }
    
    int robIncluded(TreeNode node, Map hmap) {
        if(node == null) return 0;
        return robExcluded(node.left, hmap) + node.val + robExcluded(node.right, hmap);
    }
}
