// https://leetcode.com/problems/delete-node-in-a-bst

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
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if(root==null)
            return root;
        
        if(root.val==key && root.right==null && root.left==null)
            return null;
        
        
        
        helper(null, root, key);
        return root;
    }
    
    
    private void helper(TreeNode parent, TreeNode curr, int key){
        
        if(curr==null)
            return;
        
        if(curr.val==key){
            
            if(parent==null){
                TreeNode left = curr.left;
                TreeNode right = curr.right;
                
                if(right!=null){
                    while(right.left!=null){
                        right=right.left;
                    }
                    right.left=left;    
                }else{
                    while(left.right!=null){
                        left=left.right;
                    }
                    left.right=right;
                }
                
            }
            
            
             else if( parent.val>curr.val){
                parent.left = curr.right;
                
                TreeNode loop = curr.right;
                while(loop.left!=null){
                    loop=loop.left;
                }
                loop.left=curr.left;
                
            }else{
                parent.right=curr.left;
                
                TreeNode loop = curr.left;
                while(loop.right!=null){
                    loop=loop.right;
                }
                loop.right=curr.right;
                
            }
            
            return;
        }
        
        helper(curr, curr.left, key);
        helper(curr, curr.right, key);
        
    }
}