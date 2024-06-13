// https://leetcode.com/problems/minimum-distance-between-bst-nodes

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
    int min = Integer.MAX_VALUE;
    TreeSet<Integer> set = new TreeSet<>();
        
    public int minDiffInBST(TreeNode root) {
        
        if(root==null)
            return 0;
        
        
        if(set.ceiling(root.val)!=null){
            min = Math.min(min, Math.abs(root.val-set.ceiling(root.val)));
        }

        if(set.floor(root.val)!=null){
            min = Math.min(min, Math.abs(root.val-set.floor(root.val)));
        }
            
        set.add(root.val);
        
        if(root.left!=null){
            minDiffInBST(root.left);
        }
        
        if(root.right!=null){
            minDiffInBST(root.right);
        }
        
        
        
        return min;
        
    }
    
    
    /* 90
     69
   49  89 
    52  */
}