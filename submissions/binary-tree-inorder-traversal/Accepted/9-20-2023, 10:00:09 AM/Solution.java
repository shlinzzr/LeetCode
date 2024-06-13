// https://leetcode.com/problems/binary-tree-inorder-traversal

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        // helper(root,res);
        // return res;
        
        Stack<TreeNode> st = new Stack<>();
        
        while(!st.isEmpty() || root!=null){
            
            if(root!=null){
                st.push(root);
                root = root.left;
                
            }else{
                root = st.pop();
                res.add(root.val);
                root=root.right;
            }
        }
        
        return res;
        
        
    }
    
    
    private void helper( TreeNode root, List<Integer>res ){
        
        if(root==null)
            return;
        
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
        
    }
    
}