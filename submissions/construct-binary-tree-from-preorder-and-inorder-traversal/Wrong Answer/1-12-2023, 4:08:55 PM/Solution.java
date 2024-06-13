// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        if(preorder.length==0 || inorder.length==0)
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int i=0;
        for(; i<inorder.length; i++){
            if(inorder[i]==preorder[0])
                break;
        }
        
        TreeNode left = preorder.length<2? null :  buildTree(Arrays.copyOfRange(preorder, 1, preorder.length), 
                                  Arrays.copyOfRange(inorder, 0, i));
        
        TreeNode right = preorder.length<3? null : buildTree(Arrays.copyOfRange(preorder, 2, preorder.length), 
                                   Arrays.copyOfRange(inorder, i+1, inorder.length));
        
        root.left = left;
        root.right = right;
        return root;
        
            
        
    }
}