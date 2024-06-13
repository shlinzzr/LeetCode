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
        
        int len = Math.min(preorder.length, inorder.length);
        if(len==0)
            return null;
        
        int rootVal = preorder[0];
        int i=0;
        for(; i<inorder.length; i++){
            if(inorder[i]==rootVal)
                break;
        }
        
        TreeNode root = new TreeNode(rootVal);
        
        if(len==1) return root;
        
        
        
        if(i>0)    
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, preorder.length),
                              Arrays.copyOfRange(inorder,  0, i));
        
        if(len-i>0)
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length),
                               Arrays.copyOfRange(inorder,  i+1, inorder.length));
        
        return root;
        
    }
}