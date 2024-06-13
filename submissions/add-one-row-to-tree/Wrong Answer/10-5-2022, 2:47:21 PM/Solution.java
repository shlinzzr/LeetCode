// https://leetcode.com/problems/add-one-row-to-tree

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        if(depth==1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        
        helper(root, val, depth, 1);
        return root;     
    }
    
    
    private void helper(TreeNode root, int val, int depth, int curr){
        if(root==null){
            return;
        }
        
        if(curr==depth-1){
            
            if(root.left!=null){
                TreeNode left = new TreeNode(val);
                left.left = root.left;
                root.left = left;
            }
             
            if(root.right!=null){
                TreeNode right = new TreeNode(val);
                right.right = root.right;
                root.right = right;
            }
            
            if(root.left==null && root.right==null){
                root.left=new TreeNode(val);
                 root.right=new TreeNode(val);
            }
            
            
            
            return;
        }
        
        helper(root.left, val, depth, curr+1);
        helper(root.right, val, depth, curr+1);
        
        
    }
}