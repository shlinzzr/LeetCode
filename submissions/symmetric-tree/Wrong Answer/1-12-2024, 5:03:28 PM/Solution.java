// https://leetcode.com/problems/symmetric-tree

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
    List<Integer> list= new ArrayList<>();
    int idx = 0;
    boolean res = true;
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) return true;
        preorder(root.left);
        postorder(root.right);
        return res;
    }
    
    private void preorder(TreeNode root){
        if(root==null) return ;
        list.add(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    
    private void postorder(TreeNode root){
        if(root==null) return ;
        if(res==false) return;
        if(idx>=list.size() || list.get(idx++)!=root.val) {
            res = false;
            return;
            
        }
        preorder(root.right);
        preorder(root.left);
    }
}