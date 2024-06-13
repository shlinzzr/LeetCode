// https://leetcode.com/problems/inorder-successor-in-bst

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if(root==null)
            return null;
        
        return dfs(null, root, p);
        

        
    }
    
    
    private TreeNode dfs(TreeNode parent, TreeNode root, TreeNode p){
        
        if(root==null)
            return parent;
        
        if(root.left!=null && root.left.val==p.val)
            return root;
        
        if(root.val==p.val)
            return root.right;
        
        if(root.val==p.val)
            return parent;
        
        if(root.val<p.val){
            return dfs(root, root.right, p);
        }else{
            return dfs(root, root.left, p);
        }
        
        
    }

}