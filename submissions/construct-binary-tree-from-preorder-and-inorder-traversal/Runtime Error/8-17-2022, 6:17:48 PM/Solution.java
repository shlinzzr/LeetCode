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
        
        return helper(preorder, inorder); 
        
    }
    
    private TreeNode helper(int[]preorder, int[] inorder){
        
        int len = preorder.length;
        
        if(len==1)
            return new TreeNode(preorder[0]);
        
        int idx=0;
        for(int i=0; i<len; i++){
            if(inorder[i]==preorder[0])
                idx=i;
        }
        
       
        
        TreeNode left=null, right=null;        
        
        
        if(len-idx-1>0){
            int[] inRight = new int[len-idx-1];    
            System.arraycopy(inorder, idx+1, inRight, 0, len-idx-1);    
            
            int[] preRight = new int[len-idx-1]; 
            System.arraycopy(preorder, 1+idx, preRight, 0, len-idx-1);
            
            right =  helper(preRight, inRight);
        }
        
        int[] inLeft = new int[idx];
        System.arraycopy(inorder, 0, inLeft, 0, idx );
        
        int[] preLeft = new int[idx];
        System.arraycopy(preorder, 1, preLeft, 0, idx);
        
        
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal,
                                     helper(preLeft, inLeft),
                                     right);
        
        return root;  
    }
    
}