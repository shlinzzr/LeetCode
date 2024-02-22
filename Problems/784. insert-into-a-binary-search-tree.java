// https://leetcode.com/problems/insert-into-a-binary-search-tree

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
          
        if(root==null){
            return new TreeNode(val);
        }
        
        helper(root, val);
        return root;
        
    }
    
    private void helper(TreeNode root, int val){
        
        if(root==null){
            return;
        }
            
        
        if(root.val>val){
            
            if(root.left==null){
                root.left=new TreeNode(val);
                return;
            }else{
                helper(root.left, val);
            }
        }else{
            
            if(root.right==null){
                root.right=new TreeNode(val);
                return;
            }else{
                helper(root.right, val);
            }
        }
        
        
        return;
        
            
        
        
    }
    
}