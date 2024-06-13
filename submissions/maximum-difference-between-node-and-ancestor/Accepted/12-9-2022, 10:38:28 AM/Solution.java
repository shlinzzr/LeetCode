// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor

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
    
    List<Integer> list;
    int max;
    public int maxAncestorDiff(TreeNode root) {
        
        list = new ArrayList<>();
        max =0;
        
        helper(root);
        
        return max;
    }
    
    
    private void helper(TreeNode root){
        
        if(root==null)
            return;
        
        for(int l : list){
            max = Math.max(max, Math.abs(l-root.val));
        }
        
        list.add(root.val);
        
        if(root.left!=null){
            helper(root.left);
            list.remove(list.size()-1);
        }
        
        if(root.right!=null){
            helper(root.right);
            list.remove(list.size()-1);
        }
        
        
        
    }
        
}