// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal

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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        if(preorder.length==0)
            return null;
        
        TreeNode root = new TreeNode(preorder[0]);
        
        int idx=0;
        for(int i=1; i<preorder.length; i++){
            
            if(preorder[0]>preorder[i])
                idx=i;   
            else 
                break;
        }
        
        
        
        
        
        if(idx>0){
            int[] leftArr = new int[idx];
            System.arraycopy(preorder, 1, leftArr, 0, idx);
            root.left = bstFromPreorder(leftArr);    
        }
        
        if(preorder.length-idx-1>0){
            int[] rightArr = new int[preorder.length-idx-1];
            System.arraycopy(preorder, idx+1, rightArr, 0, preorder.length-idx-1);
            root.right =  bstFromPreorder(rightArr);  
        }
            
        return root;        
        
    }
}