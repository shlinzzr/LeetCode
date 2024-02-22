// https://leetcode.com/problems/merge-two-binary-trees

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1==null)
            return root2;
        if(root2==null)
            return root1;
        
        traversal(root1, root2);
        
        return root1;
    }
    
    private void traversal(TreeNode n1, TreeNode n2){
        
        n1.val += n2.val;
        
        if(n1.left !=null && n2.left!=null){
            traversal(n1.left, n2.left);
            
        }
        
        if(n1.right !=null && n2.right!=null){
            traversal(n1.right, n2.right);
        }
        
        if(n1.left==null && n2.left!=null){
            n1.left = n2.left;
        }
        
        if(n1.right==null && n2.right!=null){
            n1.right = n2.right;
        }
            
            
        
    } 
}